# 배경
Farmer는 농장에서 매일 매일 일을 한다. 어느날 부터인가 얼마나 일했는지를 정확히 알고 싶어 관리 

## CRUD 목적
일반적으로 Data를 접근하여 CRUD를 다루는 이유는 간단하다. 대부분의 EndUser는 마지막 속성에만 관심이 있다. 


```sql
CREATE USER 'potato' @'%' IDENTIFIED BY '1234';

CREATE DATABASE farm  DEFAULT CHARACTER SET UTF8 COLLATE UTF8_UNICODE_CI;;

CREATE DATABASE test_farm DEFAULT CHARACTER SET UTF8 COLLATE UTF8_UNICODE_CI;;

GRANT ALL PRIVILEGES ON farm.* TO 'potato' @'%';

GRANT ALL PRIVILEGES ON test_farm.* TO 'potato' @'%';
```

  
