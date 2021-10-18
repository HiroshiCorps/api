/*
 *  Copyright (C) GIMENEZ Nino and PHILIPPE Nelson - All Rights Reserved
 *  * Unauthorized copying or modification of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by GIMENEZ Nino and PHILIPPE Nelson, ninogmz33@gmail.com | philippenelson59@gmail.com - 2021
 *
 */

package fr.redxil.api.common.sql;

import fr.redxil.api.common.Callback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface SQLConnection {

    void initConnection();

    boolean isConnected();

    void closeConnection();

    PreparedStatement prepareStatement(Connection conn, String query, Object... vars);

    void asyncQuery(final String query, final Callback<SQLRowSet> callback, final Object... vars);

    SQLRowSet query(final String query, final Object... vars);

    void query(final String query, final Callback<ResultSet> callback, final Object... vars);

    void asyncExecuteCallback(final String query, final Callback<Integer> callback, final Object... vars);

    void asyncExecute(final String query, final Object... vars);

    ResultSet execute(final String query, final Object... vars);

}
