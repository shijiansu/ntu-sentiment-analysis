create or replace view view_engagement as 
select 
p.id,
f.id as facebook_group,
concat(f.id, ' ', p.facebook_page) as facebook_name,
f.country,
case 
when f.country = 'USA' then 1 
when f.country = 'Canada' then 2 
when f.country = 'Singapore' then 3 
end as country_group,
case
when f.country = 'USA' then 1
else 0
end as is_country_usa,
p.post_id,
p.likes as count_of_like,
p.comments_all as count_of_comment,
p.shares as count_of_share,
p.comment_likes as count_of_comment_like,
p.engagement,
str_to_date(p.post_published, '%Y-%m-%d') as post_published,
left(p.post_published, 7) as post_published_yearmonth,
cast(left(p.post_published, 4) as unsigned) as post_published_year
from _1_post p
left join _facebook f on p.facebook_page = f.facebook_page
order by country_group asc, p.facebook_page asc, post_published asc
;

create or replace view view_engagement_1 as 
select * from
view_engagement p
where p.facebook_name = '1 Prevent Cancer Foundation'
;

create or replace view view_engagement_2 as 
select * from
view_engagement p
where p.facebook_name = '2 Cancer Prevention Coalition'
;

create or replace view view_engagement_3 as 
select * from
view_engagement p
where p.facebook_name = '3 Norris Cotton Cancer Center'
;

create or replace view view_engagement_4 as 
select * from
view_engagement p
where p.facebook_name = '4 Prevent Cancer Now'
;

create or replace view view_engagement_5 as 
select * from
view_engagement p
where p.facebook_name = '5 365 Cancer Prevention Society'
;
