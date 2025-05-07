--Users 1명
INSERT INTO Users (
    id, userName, loginId, password, phoneNumber, role,
    companyName, teamName, jobType, isActive
) VALUES (
    seqUsers.NEXTVAL,       -- 자동 증가 ID
    '홍길동',                 -- 이름
    'hong',                 -- 로그인 ID
    '123',                  -- 비밀번호 (암호화 전 예시)
    '010-1234-5678',        -- 연락처
    'MEMBER',          -- 권한
    '삼진설비',               -- 업체명
    '배관 1팀',                   -- 팀명
    '배관',                 -- 직종명
    'Y'                     -- 재직 여부
);
select * from users;

UPDATE Users
SET role = 'ROLE_MEMBER'
WHERE loginId = 'hong';

UPDATE Users
SET role = 'ROLE_ADMIN'
WHERE loginId = 'tiger';

commit;