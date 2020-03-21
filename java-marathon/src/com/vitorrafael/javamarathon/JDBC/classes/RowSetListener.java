package com.vitorrafael.javamarathon.JDBC.classes;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import java.sql.SQLException;

public class RowSetListener implements javax.sql.RowSetListener {
    @Override
    public void rowSetChanged(RowSetEvent event) {
        System.out.println("The command execute was executed.");
    }

    @Override
    public void rowChanged(RowSetEvent event) {
        System.out.println("Row updated, deleted or inserted from the RowSet");
        if(event.getSource() instanceof RowSet) {
            try {
                ((RowSet) event.getSource()).execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void cursorMoved(RowSetEvent event) {
        System.out.println("The cursor has moved.");
    }
}
