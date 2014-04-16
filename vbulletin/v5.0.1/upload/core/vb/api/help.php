<?php
if (!defined('VB_ENTRY')) die('Access denied.');
/*======================================================================*\
|| #################################################################### ||
|| # vBulletin 5.0.1
|| # ---------------------------------------------------------------- # ||
|| # Copyright ©2000-2013 vBulletin Solutions Inc. All Rights Reserved. ||
|| # This file may not be redistributed in whole or significant part. # ||
|| # ---------------- VBULLETIN IS NOT FREE SOFTWARE ---------------- # ||
|| # http://www.vbulletin.com | http://www.vbulletin.com/license.html # ||
|| #################################################################### ||
\*======================================================================*/

/**
 * vB_Api_FAQ
 *
 * @package vBApi
 * @access public
 */

class vB_Api_Help extends vB_Api
{
	// cleaner instance
	protected $cleanerObj;

	/**
	 * Initializes an Api Help object
	 */
	public function __construct()
	{
		parent::__construct();
		$this->cleanerObj = new vB_Cleaner();
	}

	/**
	 * fetches the help hierarchy, title phrases are included but text phrases are not
	 * @return array
	 *  * titles contains the hierarchy which sub-help items under the 'children' key
	 *  * firstItem contains the first help item to display
	 */
	public function getTitles()
	{
		$cache = vB_Cache::instance(vB_Cache::CACHE_LARGE);
		$titles = $cache->read('vb_FAQ_Titles');
		if (empty($titles))
		{
			$assertor = vB::getDbAssertor();

			$phrases = $assertor->getColumn('vBForum:phrase','text',
					array(vB_dB_Query::TYPE_KEY => vB_dB_Query::QUERY_SELECT,
							'fieldname' => 'faqtitle',
							'languageid' => array(-1, 0, vB::getCurrentSession()->get('languageid')),
					), false, 'varname'
			);
			$faqs = $assertor->getRows('vBForum:faq', array(), 'displayorder', 'faqname');
			foreach($faqs AS &$faq)
			{
				$faq['title_phrase'] = $faq['faqname']. '_gfaqtitle';
				$faq['text_phrase'] = $faq['faqname']. '_gfaqtext';
				$faq['title'] = $phrases[$faq['title_phrase']];
				$parentPath = '';
				$parent = $faq['faqparent'];
				while ($parent != 'faqroot')
				{
					$parentPath = $faqs[$parent]['faqname'] . '/' . $parentPath;
					$parent=$faqs[$parent]['faqparent'];
				}
				$faq['path'] = $parentPath . $faq['faqname'];
				$faqs[$faq['faqparent']]['children'][$faq['faqname']] = &$faq;
			}
			$titles = $faqs['faqroot']['children'];
			$cache->write('vb_FAQ_Titles', $titles, 300, 'vB_FAQ_chg');
		}
		$item = current($titles);
		while (!empty($item))
		{
			if (empty($item['children']))
			{
				break;
			}
			$item=current($item['children']);
		}
		return array('titles' => $titles, 'firstItem' => $item);
	}

	/**
	 * fetches the FAQs item belonging to the given group under the "answers" key
	 * title and test phrases are included
	 * @param string $group
	 * @throws vB_Exception_Api
	 * @return array
	 */
	public function getAnswers($group)
	{
		if (empty($group))
		{
			throw new vB_Exception_Api("invalid_FAQ_group", array($group));
		}
		$cache = vB_Cache::instance(vB_Cache::CACHE_LARGE);
		$answers = $cache->read('vb_FAQ_Answers_' . $group);
		if (!empty($answers))
		{
			return array('answers' => $answers);
		}
		$assertor = vB::getDbAssertor();
		$displayorder = array();
		$phrases = $assertor->getColumn('vBForum:phrase','text',
				array(vB_dB_Query::TYPE_KEY => vB_dB_Query::QUERY_SELECT,
						'fieldname' => array('faqtext', 'faqtitle'),
						'languageid' => array(-1, 0, vB::getCurrentSession()->get('languageid')),
				), false, 'varname'
		);
		$faqs = $assertor->assertQuery('vBForum:faq', array('faqparent' => $group));
		foreach($faqs AS $faq)
		{
			$faq['title'] = $phrases["$faq[faqname]_gfaqtitle"];
			$faq['text'] = $phrases["$faq[faqname]_gfaqtext"];
			$faqcache["$faq[faqname]"] = $faq;
			$displayorder["$faq[displayorder]"][] =& $faqcache["$faq[faqname]"];
		}

		ksort($displayorder);

		foreach($displayorder AS $faqs)
		{
			foreach($faqs AS $faq)
			{
				$ifaqcache["$faq[faqparent]"]["$faq[faqname]"] =& $faqcache["$faq[faqname]"];
			}
		}
		$ifaqcache = $ifaqcache[$group];
		$cache->write('vb_FAQ_Answers_' . $group, $ifaqcache, 300, 'vB_FAQ_chg');
		return array('answers' => $ifaqcache);

	}
	/**
	 * fetches one FAQ with the title and text phrases filled in
	 * @param string $title
	 * @param string $group - optional. provide if available to take advantage of the cache
	 * @throws vB_Exception_Api
	 */
	public function getAnswer($title, $group = false)
	{
		if (empty($title))
		{
			throw new vB_Exception_Api("invalid_FAQ_title", array($title));
		}

		if (!empty($group))
		{
			$answers = $this->getAnswers($group);
			if (!empty($answers[$title]))
			{
				return array('answer' => $answers[$title]);
			}
		}

		$assertor = vB::getDbAssertor();

		$phrases = $assertor->getColumn('vBForum:phrase','text',
				array(vB_dB_Query::TYPE_KEY => vB_dB_Query::QUERY_SELECT,
						'fieldname' => array('faqtext', 'faqtitle'),
						'languageid' => array(-1, 0, vB::getCurrentSession()->get('languageid')),
						'varname' => array($title.'_gfaqtitle', $title.'_gfaqtext')
				), false, 'varname'
		);
		$faq = $assertor->getRow('vBForum:faq', array('faqname' => $title));
		if (empty($faq))
		{
			throw new vB_Exception_Api("invalid_FAQ_title", array($title));
		}

		$faq['title'] = $phrases["$faq[faqname]_gfaqtitle"];
		$faq['text'] = $phrases["$faq[faqname]_gfaqtext"];

		return array('answer' => $faq);
	}

	/**
	 * Searches for keywords in the FAQ title and/or text
	 * @param string $keywords
	 * @param bool $titleandtext
	 * @param string $match (can be any/all/phr)
	 * @return array
	 * 	*titles - contains the list of matching FAQ items - title phrases are included
	 * 	*keywords - contains the list of keywords used for the search
	 */
	public function searchTitles($keywords, $titleandtext = true, $match = 'any')
	{
		$assertor = vB::getDbAssertor();
		$languages = array(-1, 0, vB::getCurrentSession()->get('languageid'));
		$fields = $titleandtext ? array('faqtitle', 'faqtext') : 'faqtitle';
		if ($match == 'any' OR !in_array($match, array('all' , 'phr')))
		{
			$search = preg_split('#[ \r\n\t]+#', $keywords);
			$phraseListRes = $assertor->assertQuery('vBForum:searchHelp', array(
					'search' => $search,
					'fields' => $fields,
					'languages' => $languages
				));
		}
		else
		{
			$conditions = array(
					array('field' => 'languageid', 'value' => $languages, 'operator' => vB_dB_Query::OPERATOR_EQ)
			);

			$conditions[] = array('field' => 'fieldname', 'value' => $fields, 'operator' => vB_dB_Query::OPERATOR_EQ);

			switch($match)
			{
				case 'all':
					$search = preg_split('#[ \r\n\t]+#', $keywords);
					foreach ($search as $word)
					{
						if (strlen($word) == 1)
						{
						// searches happen anywhere within a word, so 1 letter searches are useless
							continue;
						}
						$conditions[] = array('field' => 'text', 'value' => $word, 'operator' => vB_dB_Query::OPERATOR_INCLUDES);
					}
				break;
				case 'phr':
					$search = array($keywords);
					$conditions[] = array('field' => 'text', 'value' => $keywords, 'operator' => vB_dB_Query::OPERATOR_INCLUDES);
				break;
			}

			$phraseListRes = $assertor->assertQuery('vBForum:phrase', array(vB_dB_Query::CONDITIONS_KEY => $conditions, vB_dB_Query::COLUMNS_KEY => array('fieldname', 'varname'),));
		}
		$titles = $title_phrases =array();
		foreach ($phraseListRes as $phrase)
		{
			//$phrases[$phrase['varname']] = $phrase;
			$phrasename = str_replace('_g' . $phrase['fieldname'], '', $phrase['varname']);
			$titles[] = $phrasename;
			$title_phrases[] = $phrasename . '_gfaqtitle';
		}

		$phrases = vB_Api::instanceInternal('phrase')->fetch($title_phrases);

		$faqcache = array();

		$faqs = $assertor->assertQuery('vBForum:faq', array('faqname' => $titles));

		foreach($faqs AS $faq)
		{
			$faq['title_phrase'] = $faq['faqname']. '_gfaqtitle';
			$faq['text_phrase'] = $faq['faqname']. '_gfaqtext';
			$faq['title'] = $phrases[$faq['title_phrase']];
			$faq['path'] = $faq['faqparent'] . '/' . $faq['faqname'];
			$faqcache["$faq[faqname]"] = $faq;
		}
		return array('titles' => $faqcache, 'keywords' => $search);
	}
}
