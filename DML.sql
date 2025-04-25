--Users 1명
INSERT INTO Users (
    id, userName, loginId, password, phoneNumber, role,
    companyName, workType, teamName, jobType, isActive
) VALUES (
    seqUsers.NEXTVAL,       -- 자동 증가 ID
    '홍길동',                 -- 이름
    'hong',                 -- 로그인 ID
    '123',                  -- 비밀번호 (암호화 전 예시)
    '010-1234-5678',        -- 연락처
    'TEAM_LEADER',          -- 권한
    '한진설비',               -- 업체명
    '배관',                  -- 공종명
    '1팀',                   -- 팀명
    '용접사',                 -- 직종명
    'Y'                     -- 재직 여부
);