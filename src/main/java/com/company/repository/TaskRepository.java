package com.company.repository;

import com.company.components.ComponentController;
import com.company.dto.TaskListDTO;

import java.sql.*;

public class TaskRepository {

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection =
                    DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_db_database",
                            "java_db_user", "java_db_pswd");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public String selectTaskList() {
        Connection connection = null;
        Statement statement = null;
        StringBuilder result = new StringBuilder();
        try {
//            Class.forName("org.postgresql.Driver");
            connection = getConnection();

            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from " + ComponentController.TASK_TABLE);

            while (resultSet.next()) {
                result.append("id->" + resultSet.getInt("id") + " "
                        + "title->" + resultSet.getString("title") + " "
                        + "content->" + resultSet.getString("content") + " "
                        + "status->" + resultSet.getBoolean("status") + " "
                        + "created_date->" + resultSet.getTimestamp("created_date") + " "
                        + "finished_date->" + resultSet.getTimestamp("finished_date") + "\n");
            }
        } catch (SQLException | RuntimeException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException | RuntimeException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }

    public int createTask(TaskListDTO dto) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "insert into " + ComponentController.TASK_TABLE + "(title,content)\n" +
                    "values(?,?);";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, dto.getTitle());
            preparedStatement.setString(2, dto.getContent());

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException | RuntimeException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public boolean checkById(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "select * from " + ComponentController.TASK_TABLE + "\n" +
                    "where id = ?;";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            while (preparedStatement.executeQuery().next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException | RuntimeException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public int updateTask(TaskListDTO dto, int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "update " + ComponentController.TASK_TABLE + "\n" +
                    "set title = ?,\n" +
                    "content = ?\n" +
                    "where id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, dto.getTitle());
            preparedStatement.setString(2, dto.getContent());
            preparedStatement.setInt(3, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException | RuntimeException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int deleteTask(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "delete " + ComponentController.TASK_TABLE + "\n" +
                    "where id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException | RuntimeException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int doneTask(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "update " + ComponentController.TASK_TABLE + "\n" +
                    "set status = true,\n" +
                    "finished_date = now()\n" +
                    "where id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException | RuntimeException e) {
                e.printStackTrace();
            }
        }
        return 0;

    }
}
