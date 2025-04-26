--테이블 삭제
DROP TABLE LiftingTasks; --(양중 작업)
DROP TABLE WeldingTasks; --(용접 작업)
DROP TABLE BoltingTasks; --(체결 작업)
DROP TABLE FusionTasks; --(융착 작업)
DROP TABLE EquipmentTasks; --(장비 사용 작업 통합 테이블)
DROP TABLE Equipments; --(장비 정보 테이블)
DROP TABLE LossReports; --(로스작업 테이블)
DROP TABLE ReportMembers; --(팀원 출퇴근정보)
DROP TABLE DailyReports; --(공사일지)
DROP TABLE Users; --(사용자)
--시퀀스 삭제
DROP SEQUENCE seqUsers; --(사용자)
DROP SEQUENCE seqDailyReports; --(공사일지)
DROP SEQUENCE seqReportMembers; --(팀원 출퇴근정보)
DROP SEQUENCE seqLiftingTasks; --(양중 작업)
DROP SEQUENCE seqWeldingTasks; --(용접 작업)
DROP SEQUENCE seqBoltingTasks; --(체결 작업)
DROP SEQUENCE seqFusionTasks; --(융착 작업)
DROP SEQUENCE seqEquipmentTasks; --(장비 사용 작업 통합 테이블)
DROP SEQUENCE seqEquipments; --(장비 정보 테이블)
DROP SEQUENCE seqLossReports; --(로스작업 테이블)

-- 사용자 테이블
CREATE TABLE Users (
    id NUMBER PRIMARY KEY,
    userName VARCHAR2(50) NOT NULL,
    loginId VARCHAR2(50) NOT NULL,
    password VARCHAR2(100) NOT NULL,
    phoneNumber VARCHAR2(50) NOT NULL,
    role VARCHAR2(20) NOT NULL,
    companyName VARCHAR2(50) NOT NULL,
--    workType VARCHAR2(50) NOT NULL,
    department VARCHAR2(50) NOT NULL,
    jobType VARCHAR2(50) NOT NULL,
    isActive CHAR(1) DEFAULT 'Y' NOT NULL CHECK (isActive IN ('Y', 'N'))
);

-- 공사일지 기본정보 테이블
CREATE TABLE DailyReports (
    id NUMBER PRIMARY KEY,
    userId NUMBER REFERENCES Users(id),
    workType VARCHAR2(50) NOT NULL,
    reportDate DATE DEFAULT SYSDATE NOT NULL,
    timeType VARCHAR2(20) NOT NULL,
    locationType VARCHAR2(20) NOT NULL,
    locationDetail VARCHAR2(1000) NOT NULL,
    content VARCHAR2(3000) NOT NULL,
    createdAt DATE DEFAULT SYSDATE NOT NULL,
    updatedAt DATE,
    status VARCHAR2(20) NOT NULL
);

-- 일지 내 팀원 출퇴근 정보 테이블
CREATE TABLE ReportMembers (
    id NUMBER PRIMARY KEY,
    reportId NUMBER REFERENCES DailyReports(id),
    memberName VARCHAR2(50) NOT NULL,
    jobType VARCHAR2(50) NOT NULL,
    workStartTime DATE NOT NULL,
    workEndTime DATE NOT NULL,
    note VARCHAR2(3000)
);

-- 양중 작업 테이블
CREATE TABLE LiftingTasks (
    id NUMBER PRIMARY KEY,
    reportId NUMBER REFERENCES DailyReports(id),
    taskItem VARCHAR2(50) NOT NULL,
    taskCount NUMBER NOT NULL,
    taskLocation VARCHAR2(100) NOT NULL,
    note VARCHAR2(3000)
);

-- 용접 작업 테이블
CREATE TABLE WeldingTasks (
    id NUMBER PRIMARY KEY,
    reportId NUMBER REFERENCES DailyReports(id),
    drawingNo VARCHAR2(50) NOT NULL,
    pointNo VARCHAR2(50) NOT NULL,
    pipeSize VARCHAR2(50) NOT NULL,
    taskType VARCHAR2(50) NOT NULL,
    memberName VARCHAR2(50) NOT NULL,
    note VARCHAR2(3000)
);

-- 체결 작업 테이블
CREATE TABLE BoltingTasks (
    id NUMBER PRIMARY KEY,
    reportId NUMBER REFERENCES DailyReports(id),
    drawingNo VARCHAR2(50) NOT NULL,
    pointNo VARCHAR2(50) NOT NULL,
    boltSize VARCHAR2(50) NOT NULL,
    taskType VARCHAR2(50) NOT NULL,
    memberName VARCHAR2(50) NOT NULL,
    note VARCHAR2(3000)
);

-- 융착 작업 테이블
CREATE TABLE FusionTasks (
    id NUMBER PRIMARY KEY,
    reportId NUMBER REFERENCES DailyReports(id),
    drawingNo VARCHAR2(50) NOT NULL,
    pointNo VARCHAR2(50) NOT NULL,
    pipeSize VARCHAR2(50) NOT NULL,
    taskType VARCHAR2(50) NOT NULL,
    memberName VARCHAR2(50) NOT NULL,
    note VARCHAR2(3000)
);

-- 장비 정보 테이블
CREATE TABLE Equipments (
    id NUMBER PRIMARY KEY,
    equipmentCode VARCHAR2(50) NOT NULL,
    equipmentName VARCHAR2(50) NOT NULL,
    spec VARCHAR2(100) NOT NULL,
    brand VARCHAR2(50) NOT NULL,
    rentalCompany VARCHAR2(50) NOT NULL,
    status VARCHAR2(50) NOT NULL,
    note VARCHAR2(3000)
);

-- 장비 사용 작업 테이블
CREATE TABLE EquipmentTasks (
    id NUMBER PRIMARY KEY,
    reportId NUMBER REFERENCES DailyReports(id),
    equipmentId NUMBER REFERENCES Equipments(id),
    taskLocation VARCHAR2(100) NOT NULL,
    startTime DATE NOT NULL,
    endTime DATE NOT NULL,
    memberName VARCHAR2(50) NOT NULL,
    taskContent VARCHAR2(3000),
    note VARCHAR2(3000)
);

-- 로스작업 테이블
CREATE TABLE LossReports (
    id NUMBER PRIMARY KEY,
    reportId NUMBER REFERENCES DailyReports(id),
    lossLocation VARCHAR2(1000) NOT NULL,
    lossType VARCHAR2(50) NOT NULL,
    memberCount NUMBER NOT NULL,
    startTime DATE NOT NULL,
    endTime DATE NOT NULL,
    note VARCHAR2(3000)
);

-- 시퀀스 생성
CREATE SEQUENCE seqUsers; --(사용자)
CREATE SEQUENCE seqDailyReports; --(공사일지)
CREATE SEQUENCE seqReportMembers; --(팀원 출퇴근정보)
CREATE SEQUENCE seqLiftingTasks; --(양중 작업)
CREATE SEQUENCE seqWeldingTasks; --(용접 작업)
CREATE SEQUENCE seqBoltingTasks; --(체결 작업)
CREATE SEQUENCE seqFusionTasks; --(융착 작업)
CREATE SEQUENCE seqEquipmentTasks; --(장비 사용 작업 통합 테이블)
CREATE SEQUENCE seqEquipments; --(장비 정보 테이블)
CREATE SEQUENCE seqLossReports; --(로스작업 테이블)
