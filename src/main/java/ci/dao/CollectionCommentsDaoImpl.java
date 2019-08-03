package ci.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ci.entity.CollectionComments;

public class CollectionCommentsDaoImpl extends _DaoImpl {

    private final String sql = "select * from _1_comments";
    
	public void insert(CollectionComments obj) {
		String sql = "insert into _1_comments"
				+ " (post_id, post_by, post_text, post_published, comment_id, "
				+ " comment_by, is_reply, comment_message, comment_published, "
				+ " comment_like_count) VALUES "
				+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		try {
			conn = getDataSource().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			//
			ps.setString(1, obj.getPostId());
			ps.setString(2, obj.getPostBy());
			ps.setString(3, obj.getPostText());
			// 2010-12-07T15:23:56+0000
			ps.setString(4, obj.getPostPublished());
			ps.setString(5, obj.getCommentId());
			ps.setString(6, obj.getCommentBy());
			ps.setInt(7, obj.getIsReply());
			ps.setString(8, obj.getCommentMessage());
			// 2010-12-07T15:23:56+0000
			ps.setString(9, obj.getCommentPublished());
			ps.setInt(10, obj.getCommentLikeCount());
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

	public List<CollectionComments> selectByPostId(String postId) throws Exception{
	    Connection conn = null;
	    conn = getDataSource().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql + " where post_id=?");
        if(postId != null){
            ps.setString(1, postId);
        }
        return select(conn, ps);
	}
	
	private List<CollectionComments> select(Connection conn, PreparedStatement ps) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			ResultSet rs = ps.executeQuery();
			List<CollectionComments> list = new ArrayList<CollectionComments>();
			while (rs.next()) {
				CollectionComments obj = new CollectionComments();
				//
				obj.setPostId(rs.getString("post_id"));
				obj.setPostBy(rs.getString("post_by"));
				obj.setPostText(rs.getString("post_text"));
				obj.setPostPublished(rs.getString("post_published"));
				obj.setCommentId(rs.getString("comment_id"));
				obj.setCommentBy(rs.getString("comment_by"));
				obj.setIsReply(rs.getInt("is_reply"));
				obj.setCommentMessage(rs.getString("comment_message"));
				obj.setCommentPublished(rs.getString("comment_published"));
				obj.setCommentLikeCount(rs.getInt("comment_like_count"));
				obj.setId(rs.getInt("id"));
				String date = rs.getString("sysdate");
				try {
					obj.setSysdate(date == null ? null : format.parse(date));
				} catch (ParseException e) {
					e.printStackTrace();
				}
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
