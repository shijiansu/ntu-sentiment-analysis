package ci.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ci.entity.CollectionPost;

public class CollectionPostDaoImpl extends _DaoImpl {

    private final String sql = "select * from _1_post";

    public void insert(CollectionPost obj) {
        String sql = "insert into _1_post"
                + " (type, by, post_message, picture, link, link_domain, post_published,"
                + " post_published_unix, likes, likes_count_fb, comments_all, comments_base,"
                + " comments_replies, shares, comment_likes, engagement, post_id,"
                + " post_link, facebook_page) VALUES" + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        try {
            conn = getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            //
            ps.setString(1, obj.getType());
            ps.setString(2, obj.getBy());
            ps.setString(3, obj.getPostMessage());
            ps.setString(4, obj.getPicture());
            ps.setString(5, obj.getLink());
            ps.setString(6, obj.getLinkDomain());
            // 2010-12-07T15:23:56+0000
            ps.setString(7, obj.getPostPublished());
            ps.setInt(8, obj.getPostPublishedUnix());
            ps.setInt(9, obj.getLikes());
            ps.setInt(10, obj.getLikesCountFb());
            ps.setInt(11, obj.getCommentsAll());
            ps.setInt(12, obj.getCommentBase());
            ps.setInt(13, obj.getCommentsReplies());
            ps.setInt(14, obj.getShare());
            ps.setInt(15, obj.getComentLikes());
            ps.setInt(16, obj.getEngagement());
            ps.setString(17, obj.getPostId());
            ps.setString(18, obj.getPostLink());
            ps.setString(19, obj.getFacebookPage());
            //
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public void updateProcessStatusToExecuted(int id) {
        String sql = "update _1_post set process_status = 1 where id=?";
        Connection conn = null;
        try {
            conn = getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            //
            ps.setInt(1, id);
            //
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public List<CollectionPost> selectByFacebookPageNotExecuted(String facebookPage) throws Exception {
        Connection conn = null;
        conn = getDataSource().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql + " where facebook_page=? and process_status = 0 ");
        if (facebookPage != null) {
            ps.setString(1, facebookPage);
        }
        return select(conn, ps);
    }

    public List<CollectionPost> select(Connection conn, PreparedStatement ps) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ResultSet rs = ps.executeQuery();
            List<CollectionPost> list = new ArrayList<CollectionPost>();
            while (rs.next()) {
                CollectionPost obj = new CollectionPost();
                //
                obj.setType(rs.getString("type"));
                obj.setBy(rs.getString("by"));
                obj.setPostMessage(rs.getString("post_message"));
                obj.setPicture(rs.getString("picture"));
                obj.setLink(rs.getString("link"));
                obj.setLinkDomain(rs.getString("link_domain"));
                obj.setPostPublished(rs.getString("post_published"));
                obj.setPostPublishedUnix(rs.getInt("post_published_unix"));
                obj.setLink(rs.getString("likes"));
                obj.setLikesCountFb(rs.getInt("likes_count_fb"));
                obj.setCommentsAll(rs.getInt("comments_all"));
                obj.setCommentBase(rs.getInt("comments_base"));
                obj.setCommentsReplies(rs.getInt("comments_replies"));
                obj.setShare(rs.getInt("shares"));
                obj.setComentLikes(rs.getInt("comment_likes"));
                obj.setEngagement(rs.getInt("engagement"));
                obj.setPostId(rs.getString("post_id"));
                obj.setPostLink(rs.getString("post_link"));
                obj.setFacebookPage(rs.getString("facebook_page"));
                obj.setId(rs.getInt("id"));
                String date = rs.getString("sysdate");
                try {
                    obj.setSysdate(date == null ? null : format.parse(date));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                obj.setProcessStatus(rs.getInt("process_status"));
                //
                list.add(obj);
            }
            rs.close();
            ps.close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

}
