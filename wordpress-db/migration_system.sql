#This query for list all categories need to add 
select SUBSTRING_INDEX(SUBSTRING_INDEX(post_title,'][',-2),'][',1) as new_title from wp_posts p group by new_title having new_title not in (select name from wp_terms) ;

//Test command
select term_taxonomy_id from wp_term_taxonomy where description ='Fairy Tail Zero' order by term_taxonomy_id DESC;
select ID,post_title from wp_posts where post_title like '%Fairy Tail Zero%' group by post_title;

//Test command
insert into wp_term_relationships (object_id,term_taxonomy_id) VALUES (75,30);

// Replace %&gt; -> '>'
select ID from wp_posts where post_title like '%&gt;%';
update wp_posts set post_title=replace(post_title,'&gt;','>') where post_title like '%&gt;%';

//ADD PREFIX [TRUYEN]
update wp_posts set post_title=concat('[TRUYEN]',post_title) where post_title not like '%[TRUYEN]%';
