<?php
class mcp_foo
{
	function module()
	{
		return array(
		    'filename'    => 'mcp_page_name',
		    'title'        => 'MCP_PAGE_TITLE',
		    'version'    => '1.2.3',
		    'modes'        => array(
			'mode1'        => array('title' => 'MCP_PAGE_MODE_ONE_TITLE', 'auth' => 'acl_m_,$id', 'cat' => array('MCP_PAGE_TITLE')),
			'mode2'        => array('title' => 'MCP_PAGE_MODE_TWO_TITLE', 'auth' => 'acl_m_,$id', 'cat' => array('MCP_PAGE_TITLE')),
		    ),
		);
	}
	function install()
	{
	}

	function uninstall()
	{
	}
}
?>
