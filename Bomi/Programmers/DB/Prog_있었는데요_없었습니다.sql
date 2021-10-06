# 있었는데요 없었습니다
SELECT ANIMAL_INS.ANIMAL_ID, ANIMAL_INS.NAME
FROM ANIMAL_INS
    JOIN ANIMAL_OUTS ON ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID
WHERE ANIMAL_OUTS.DATETIME<ANIMAL_INS.DATETIME
ORDER BY ANIMAL_INS.DATETIME;