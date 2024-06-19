package com.yearup.dealership.db;

import com.yearup.dealership.models.Vehicle;

import javax.sql.DataSource;
import java.awt.image.VolatileImage;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private DataSource dataSource;

    public VehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicle(Vehicle vehicle) {

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    """
                            INSERT INTO vehicles (VIN, make, model, year, SOLD, color, vehicleType, odometer, price)
                            VALUES (?, ?, ?, ?, ?, ?, ?, ? , ?)
                        """
            )
        ){
            preparedStatement.setString(1,vehicle.getVin());
            preparedStatement.setString(2,vehicle.getMake());
            preparedStatement.setString(3,vehicle.getModel());
            preparedStatement.setInt(4,vehicle.getYear());
            preparedStatement.setBoolean(5,vehicle.isSold());
            preparedStatement.setString(6,vehicle.getColor());
            preparedStatement.setString(7, vehicle.getVehicleType());
            preparedStatement.setInt(8,vehicle.getOdometer());
            preparedStatement.setDouble(9,vehicle.getPrice());

            preparedStatement.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void removeVehicle(String VIN) {

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    """
                            DELETE FROM vehicles WHERE VIN  = ?
                            """
            )){
            preparedStatement.setString(1,VIN);

            preparedStatement.executeUpdate();

        }catch (Exception ex ){
            ex.printStackTrace();
        }
    }

    public List<Vehicle> searchByPriceRange(double minPrice, double maxPrice) {

        List<Vehicle> vehicles= new ArrayList<>();
        String priceQuery = "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(priceQuery)){

            preparedStatement.setDouble(1,minPrice);
            preparedStatement.setDouble(2,maxPrice);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){

                    String VIN = resultSet.getString("VIN");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    int year = resultSet.getInt("year");
                    Boolean sold = resultSet.getBoolean("SOLD");
                    String color = resultSet.getString("color");
                    String vehicleType = resultSet.getString("vehicleType");
                    int odometer = resultSet.getInt("odometer");
                    double price = resultSet.getDouble("price");
                    Vehicle vehicle = new Vehicle(VIN,make,model,year,sold,color,vehicleType,odometer,price);
                    vehicles.add(vehicle);
                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByMakeModel(String make, String model) {

        List<Vehicle> vehicles = new ArrayList<>();
        String makeModelQuery = "SELECT * FROM vehicles WHERE make = ? AND model = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(makeModelQuery)){

            preparedStatement.setString(1,make);
            preparedStatement.setString(2,model);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    String VIN = resultSet.getString("VIN");
                    String makeOf = resultSet.getString("make");
                    String modelOf = resultSet.getString("model");
                    int year = resultSet.getInt("year");
                    Boolean sold = resultSet.getBoolean("SOLD");
                    String color = resultSet.getString("color");
                    String vehicleType = resultSet.getString("vehicleType");
                    int odometer = resultSet.getInt("odometer");
                    double price = resultSet.getDouble("price");
                    Vehicle vehicle = new Vehicle(VIN,makeOf,modelOf,year,sold,color,vehicleType,odometer,price);
                    vehicles.add(vehicle);

                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByYearRange(int minYear, int maxYear) {

        List<Vehicle> vehicles= new ArrayList<>();
        String yearQuery = "SELECT * FROM vehicles WHERE year BETWEEN ? AND ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(yearQuery)){

            preparedStatement.setDouble(1,minYear);
            preparedStatement.setDouble(2,maxYear);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){

                    String VIN = resultSet.getString("VIN");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    int year = resultSet.getInt("year");
                    Boolean sold = resultSet.getBoolean("SOLD");
                    String color = resultSet.getString("color");
                    String vehicleType = resultSet.getString("vehicleType");
                    int odometer = resultSet.getInt("odometer");
                    double price = resultSet.getDouble("price");
                    Vehicle vehicle = new Vehicle(VIN,make,model,year,sold,color,vehicleType,odometer,price);
                    vehicles.add(vehicle);
                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return vehicles;

    }

    public List<Vehicle> searchByColor(String color) {

        List<Vehicle> vehicles = new ArrayList<>();
        String colorQuery = "SELECT * FROM vehicles WHERE color = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(colorQuery)){

            preparedStatement.setString(1,color);


            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    String VIN = resultSet.getString("VIN");
                    String makeOf = resultSet.getString("make");
                    String modelOf = resultSet.getString("model");
                    int year = resultSet.getInt("year");
                    Boolean sold = resultSet.getBoolean("SOLD");
                    String colorOf = resultSet.getString("color");
                    String vehicleType = resultSet.getString("vehicleType");
                    int odometer = resultSet.getInt("odometer");
                    double price = resultSet.getDouble("price");
                    Vehicle vehicle = new Vehicle(VIN,makeOf,modelOf,year,sold,colorOf,vehicleType,odometer,price);
                    vehicles.add(vehicle);

                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByMileageRange(int minMileage, int maxMileage) {

        List<Vehicle> vehicles= new ArrayList<>();
        String mileageQuery = "SELECT * FROM vehicles WHERE odometer BETWEEN ? AND ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(mileageQuery)){

            preparedStatement.setInt(1,minMileage);
            preparedStatement.setInt(2,maxMileage);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){

                    String VIN = resultSet.getString("VIN");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    int year = resultSet.getInt("year");
                    Boolean sold = resultSet.getBoolean("SOLD");
                    String color = resultSet.getString("color");
                    String vehicleType = resultSet.getString("vehicleType");
                    int odometer = resultSet.getInt("odometer");
                    double price = resultSet.getDouble("price");
                    Vehicle vehicle = new Vehicle(VIN,make,model,year,sold,color,vehicleType,odometer,price);
                    vehicles.add(vehicle);
                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByType(String type) {

        List<Vehicle> vehicles = new ArrayList<>();
        String typeQuery = "SELECT * FROM vehicles WHERE vehicleType LIKE ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(typeQuery)){

            preparedStatement.setString(1,type);


            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    String VIN = resultSet.getString("VIN");
                    String makeOf = resultSet.getString("make");
                    String modelOf = resultSet.getString("model");
                    int year = resultSet.getInt("year");
                    Boolean sold = resultSet.getBoolean("SOLD");
                    String colorOf = resultSet.getString("color");
                    String vehicleType = resultSet.getString("vehicleType");
                    int odometer = resultSet.getInt("odometer");
                    double price = resultSet.getDouble("price");
                    Vehicle vehicle = new Vehicle(VIN,makeOf,modelOf,year,sold,colorOf,vehicleType,odometer,price);
                    vehicles.add(vehicle);

                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return vehicles;
    }

    private Vehicle createVehicleFromResultSet(ResultSet resultSet) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVin(resultSet.getString("VIN"));
        vehicle.setMake(resultSet.getString("make"));
        vehicle.setModel(resultSet.getString("model"));
        vehicle.setYear(resultSet.getInt("year"));
        vehicle.setSold(resultSet.getBoolean("SOLD"));
        vehicle.setColor(resultSet.getString("color"));
        vehicle.setVehicleType(resultSet.getString("vehicleType"));
        vehicle.setOdometer(resultSet.getInt("odometer"));
        vehicle.setPrice(resultSet.getDouble("price"));
        return vehicle;
    }
}
