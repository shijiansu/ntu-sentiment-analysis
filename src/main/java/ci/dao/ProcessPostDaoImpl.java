package ci.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ci.entity.ProcessPost;

public class ProcessPostDaoImpl extends _DaoImpl {

    public void insert(ProcessPost obj) {
        String sql = "insert into _2_process_post "
                + "(facebook_page, cw, post_id, ssp, cpc, cnc, cnlc, collection_post_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        try {
            conn = getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            //
            ps.setString(1, obj.getFacebookPage());
            ps.setInt(2, obj.getCw());
            ps.setString(3, obj.getPostId());
            ps.setDouble(4, obj.getSsp());
            ps.setInt(5, obj.getCpc());
            ps.setInt(6, obj.getCnc());
            ps.setInt(7, obj.getCnlc());
            ps.setInt(8, obj.getCollectionPostId());
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

    public List<ProcessPost> select() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "select * from _2_process_post";

        Connection conn = null;
        try {
            conn = getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            List<ProcessPost> list = new ArrayList<ProcessPost>();
            while (rs.next()) {
                ProcessPost obj = new ProcessPost();
                //
                obj.setId(rs.getInt("id"));
                obj.setFacebookPage(rs.getString("facebook_page"));
                obj.setCw(rs.getInt("cw"));
                obj.setPostId(rs.getString("post_id"));
                obj.setSsp(rs.getDouble("ssp"));
                obj.setCpc(rs.getInt("cpc"));
                obj.setCnc(rs.getInt("cnc"));
                obj.setCnlc(rs.getInt("cnlc"));
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
