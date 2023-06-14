package ro.pao.repository.implementations;

import ro.pao.configuration.DatabaseConfiguration;
import ro.pao.mapper.WorkPartMapper;
import ro.pao.model.WorkPart;
import ro.pao.repository.WorkPartRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class WorkPartRepositoryImpl implements WorkPartRepository {

    private static final WorkPartMapper workPartMapper = WorkPartMapper.getInstance();

    @Override
    public Optional<WorkPart> getWorkPartById(UUID id) {
        String selectSql = "SELECT * FROM work_parts WHERE id=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return WorkPartMapper.mapToWorkPart(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteWorkPart(UUID id) {
        String deleteNameSql = "DELETE FROM work_parts WHERE id=?";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteNameSql)) {
            preparedStatement.setString(1, id.toString());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateWorkPartById(UUID id, WorkPart newWorkPart) {
//        String updateNameSql = "UPDATE work_parts \n" +
//                "SET code=?, \n" +
//                "name=?, \n" +
//                "price=?, \n" +
//                "workId=?, \n" +
//                "WHERE id=?";
//
//        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
//            preparedStatement.setString(1, newWorkPart.getCode());
//            preparedStatement.setString(2, newWorkPart.getName());
//            preparedStatement.setDouble(3, newWorkPart.getPrice());
//            preparedStatement.setString(4, newWorkPart.getWorkId().toString());
//            preparedStatement.setString(5, id.toString());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void addNewWorkPart(WorkPart workPart) {
        String insertSql = "INSERT INTO work_parts (id, code, name, price, workId) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setObject(1, workPart.getId());
            preparedStatement.setString(2, workPart.getCode());
            preparedStatement.setString(3, workPart.getName());
            preparedStatement.setDouble(4, workPart.getPrice());
            preparedStatement.setObject(5, workPart.getWorkId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<WorkPart> getAllWorkPart() {
        String selectSql = "SELECT * FROM work_parts";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            return WorkPartMapper.mapToWorkPartList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    @Override
    public void addAllFromWorkPartList(List<WorkPart> workPartList) {
        workPartList.forEach(this::addNewWorkPart);
    }

    @Override
    public List<String[]> getAllWorkPartByWorkId(UUID workId) {
        List<String[]> workPartCosts = new ArrayList<>();
        List<WorkPart> workParts = this.getAllWorkPart().stream().filter(workPart -> workPart.getWorkId().equals(workId)).toList();

        workParts.forEach(workPart -> {
            String[] workPartCost = new String[2];
            workPartCost[0] = workPart.getName();
            workPartCost[1] = workPart.getPrice().toString();
            workPartCosts.add(workPartCost);
        });

        return workPartCosts;
    }
}
