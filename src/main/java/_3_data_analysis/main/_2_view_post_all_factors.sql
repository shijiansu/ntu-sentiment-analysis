create or replace view view_post_all_factors as 
select 
p.id,
f.id                               as facebook_group,
concat(f.id, ' ', p.facebook_page) as facebook_name,
f.country,
case 
when f.country = 'USA' then 1 
when f.country = 'Canada' then 2 
when f.country = 'Singapore' then 3 
end                                as country_group,
case
when f.country = 'USA' then 1
else 0
end                                as is_country_usa,
p.post_id,
# content
pp.cw                                                   as count_of_word,
case when pp.cw < 30 then 1 else 0 end                  as is_cwl30,
case when 30 <= pp.cw and pp.cw < 70 then 1 else 0 end  as is_cwm30,
case when 70 <= pp.cw and pp.cw < 100 then 1 else 0 end as is_cwm70,
case when 100 <= pp.cw then 1 else 0 end                as is_cwm100,
case when floor(pp.cw / 10) > 10 then 10 else floor(pp.cw / 10) end as count_of_word_level,
# is with picture
case when p.picture is null then 0 else 1 end                as is_pic,
# sentiment analysis of post
pp.ssp                                                             as sentiment_score_of_post,
case when pp.ssp > 0 then 1 else 0 end                             as is_positive_post,
case when pp.ssp < 0 then 1 else 0 end                             as is_negative_post,
case when pp.ssp = 0 then 1 else 0 end                             as is_neutral_post,
case when pp.ssp < 0 then 1 when pp.ssp = 0 then 2 else 3 end      as sentiment_of_post_group,
# sentiment analysis of comment
pp.cpc             as count_of_positive_comment,
pp.cnc             as count_of_negative_comment,
pp.cnlc            as count_of_neutral_comment,
pp.cpc - pp.cnc    as sentiment_score_of_comment,
case when pp.cpc - pp.cnc > 0 then 1 else 0 end                                      as is_positive_comment,
case when pp.cpc - pp.cnc < 0 then 1 else 0 end                                      as is_negative_comment,
case when pp.cpc - pp.cnc = 0 then 1 else 0 end                                      as is_neutral_comment,
case when pp.cpc - pp.cnc < 0 then 1 when pp.cpc - pp.cnc = 0 then 2 else 3 end      as sentiment_of_comment_group,
# engagement
p.likes         as count_of_like,
p.comments_all  as count_of_comment,
p.shares        as count_of_share,
p.comment_likes as count_of_comment_like,
p.engagement,
case when p.comments_all > 0 then 1 else 0 end  as is_commented,
case when p.likes > 0 then 1 else 0 end         as is_liked,
case when p.shares > 0 then 1 else 0 end        as is_shared,
# date
str_to_date(p.post_published, '%Y-%m-%d')       as post_published,
left(p.post_published, 7)                       as post_published_yearmonth,
cast(left(p.post_published, 4) as unsigned)     as post_published_year
from _1_post p
left join _facebook f on p.facebook_page = f.facebook_page
left join _2_process_post pp on pp.post_id = p.post_id
order by country_group asc, p.facebook_page asc, post_published asc
;

create or replace view view_post_all_factors_1 as 
select * from
view_post_all_factors p
where p.facebook_name = '1 Prevent Cancer Foundation'
;

create or replace view view_post_all_factors_2 as 
select * from
view_post_all_factors p
where p.facebook_name = '2 Cancer Prevention Coalition'
;

create or replace view view_post_all_factors_3 as 
select * from
view_post_all_factors p
where p.facebook_name = '3 Norris Cotton Cancer Center'
;

create or replace view view_post_all_factors_4 as 
select * from
view_post_all_factors p
where p.facebook_name = '4 Prevent Cancer Now'
;

create or replace view view_post_all_factors_5 as 
select * from
view_post_all_factors p
where p.facebook_name = '5 365 Cancer Prevention Society'
;
