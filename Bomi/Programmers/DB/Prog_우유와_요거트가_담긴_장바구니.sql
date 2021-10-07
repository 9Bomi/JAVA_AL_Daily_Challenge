# 우유와 요거트가 담긴 장바구니
SELECT DISTINCT CART_ID 
FROM CART_PRODUCTS
WHERE  NAME = 'Yogurt'
    AND
    CART_ID IN (
        SELECT CART_ID 
        FROM CART_PRODUCTS
        WHERE NAME = 'Milk'
    )
ORDER BY ID;