#This query for list all categories need to add 
select SUBSTRING_INDEX(SUBSTRING_INDEX(post_title,'][',-2),'][',1) as new_title from wp_posts p group by new_title having new_title not in (select name from wp_terms) ;
