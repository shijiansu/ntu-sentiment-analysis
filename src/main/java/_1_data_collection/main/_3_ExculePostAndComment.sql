delete from _1_comments
where post_id not in (
  select post_id from _1_post
)
;
