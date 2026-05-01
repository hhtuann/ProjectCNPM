DROP DATABASE IF EXISTS db_labor_contract;
CREATE DATABASE db_labor_contract CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE
    db_labor_contract;

-- Tắt kiểm tra khóa ngoại tạm thời để có thể Drop bảng cũ (nếu chạy lại script)
SET
    FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS tblContractJobShift;
DROP TABLE IF EXISTS tblContractJob;
DROP TABLE IF EXISTS tblContract;
DROP TABLE IF EXISTS tblShift;
DROP TABLE IF EXISTS tblJob;
DROP TABLE IF EXISTS tblCustomer;
DROP TABLE IF EXISTS tblSalesManager;
DROP TABLE IF EXISTS tblUser;

-- Bật lại kiểm tra khóa ngoại
SET
    FOREIGN_KEY_CHECKS = 1;

-- 1. Tạo bảng tblUser
CREATE TABLE tblUser
(
    id          INT(10) AUTO_INCREMENT PRIMARY KEY,
    username    VARCHAR(255) UNIQUE NOT NULL,
    password    VARCHAR(255)        NOT NULL,
    fullName    VARCHAR(50),
    dateOfBirth DATE,
    idCard      VARCHAR(12) UNIQUE,
    phone       VARCHAR(10),
    email       VARCHAR(255),
    address     VARCHAR(255),
    role        VARCHAR(255)
);

-- 2. Tạo bảng tblSalesManager (Quan hệ 1-1 kế thừa từ tblUser)
CREATE TABLE tblSalesManager
(
    userId INT(10) PRIMARY KEY,
    FOREIGN KEY (userId) REFERENCES tblUser (id) ON DELETE CASCADE
);

-- 3. Tạo bảng tblCustomer
CREATE TABLE tblCustomer
(
    id          INT(10) AUTO_INCREMENT PRIMARY KEY,
    fullName    VARCHAR(50),
    dateOfBirth DATE,
    idCard      VARCHAR(12) UNIQUE,
    phone       VARCHAR(10),
    email       VARCHAR(255),
    address     VARCHAR(255),
    type        VARCHAR(255)
);

-- 4. Tạo bảng tblJob
CREATE TABLE tblJob
(
    id          INT(10) AUTO_INCREMENT PRIMARY KEY,
    jobName     VARCHAR(255),
    description VARCHAR(255),
    skill       VARCHAR(255)
);

-- 5. Tạo bảng tblShift
CREATE TABLE tblShift
(
    id          INT(10) AUTO_INCREMENT PRIMARY KEY,
    workingDate DATE,
    startTime   TIME,
    endTime     TIME
);

-- 6. Tạo bảng tblContract
CREATE TABLE tblContract
(
    id             INT(10) AUTO_INCREMENT PRIMARY KEY,
    contractDate   DATE,
    paymentMethod  VARCHAR(255),
    status         VARCHAR(255),
    salesManagerId INT(10),
    customerId     INT(10),
    FOREIGN KEY (salesManagerId) REFERENCES tblSalesManager (userId),
    FOREIGN KEY (customerId) REFERENCES tblCustomer (id)
);

-- 7. Tạo bảng tblContractJob
CREATE TABLE tblContractJob
(
    id         INT(10) AUTO_INCREMENT PRIMARY KEY,
    contractId INT(10),
    jobId      INT(10),
    FOREIGN KEY (contractId) REFERENCES tblContract (id) ON DELETE CASCADE,
    FOREIGN KEY (jobId) REFERENCES tblJob (id)
);

-- 8. Tạo bảng tblContractJobShift
CREATE TABLE tblContractJobShift
(
    id              INT(10) AUTO_INCREMENT PRIMARY KEY,
    requiredWorkers INT(10),
    agreedWage      FLOAT(10),
    shiftId         INT(10),
    contractJobId   INT(10),
    FOREIGN KEY (shiftId) REFERENCES tblShift (id),
    FOREIGN KEY (contractJobId) REFERENCES tblContractJob (id) ON DELETE CASCADE
);