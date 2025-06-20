-- Create table if not exists
CREATE TABLE IF NOT EXISTS sensor_data (
                                           id INT AUTO_INCREMENT PRIMARY KEY,
                                           detection_time TIMESTAMP NOT NULL,
                                           distance DECIMAL(5,2) NOT NULL,
    energy INT NOT NULL,
    is_moving BOOLEAN NOT NULL,
    sensitivity_level INT,
    sensor_location VARCHAR(50)
    );

-- Insert sensor data
INSERT INTO sensor_data (detection_time, distance, energy, is_moving, sensitivity_level, sensor_location) VALUES
                                                                                                              ('2023-11-01 08:15:23', 2.10, 45, TRUE, 3, 'Living Room'),
                                                                                                              ('2023-11-01 08:23:47', 1.80, 78, TRUE, 3, 'Living Room'),
                                                                                                              ('2023-11-01 09:05:12', 0.90, 85, FALSE, 2, 'Living Room'),
                                                                                                              ('2023-11-01 10:22:35', 3.10, 45, TRUE, 3, 'Living Room'),
                                                                                                              ('2023-11-02 07:58:12', 1.50, 92, TRUE, 3, 'Bedroom'),
                                                                                                              ('2023-11-02 09:13:45', 2.70, 67, TRUE, 3, 'Bedroom'),
                                                                                                              ('2023-11-02 11:07:33', 1.20, 88, FALSE, 2, 'Bedroom'),
                                                                                                              ('2023-11-02 14:45:19', 0.80, 95, FALSE, 2, 'Bedroom'),
                                                                                                              ('2023-11-03 08:30:15', 2.40, 62, TRUE, 3, 'Kitchen'),
                                                                                                              ('2023-11-03 09:45:28', 2.10, 74, TRUE, 3, 'Kitchen'),
                                                                                                              ('2023-11-03 12:12:12', 1.30, 82, FALSE, 2, 'Kitchen'),
                                                                                                              ('2023-11-03 15:33:47', 1.90, 68, TRUE, 3, 'Kitchen'),
                                                                                                              ('2023-11-07 08:20:15', 2.00, 77, TRUE, 3, 'Living Room'),
                                                                                                              ('2023-11-07 08:21:37', 2.10, 75, TRUE, 3, 'Living Room'),
                                                                                                              ('2023-11-07 08:22:48', 2.30, 72, TRUE, 3, 'Living Room'),
                                                                                                              ('2023-11-07 08:24:13', 2.50, 70, TRUE, 3, 'Living Room'),
                                                                                                              ('2023-11-07 08:26:29', 2.70, 68, TRUE, 3, 'Living Room');
