# DATETIME에서 DATE로 형 변환
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME,'%Y-%m-%d')
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;