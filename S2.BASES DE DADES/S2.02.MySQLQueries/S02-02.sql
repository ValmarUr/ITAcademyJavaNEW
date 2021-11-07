USE queries_mysql;

-- 1. Obtener todos los datos de todos los empleados.
SELECT EMPNO, ENAME, JOB, IFNULL(MGR, "") AS MGR, DATE_FORMAT(HIREDATE, "%d/%m/%y") AS HIREDATE, SAL, IFNULL(COMM, "") AS COMM, DEPTNO
FROM empleados;

-- 2. Obtener todos los datos de todos los departamentos.
SELECT DEPTNO, DNAME, LOC
FROM departamentos;

-- 3. Obtener todos los datos de los administrativos (su trabajo es, en ingles, 'CLERK').
SELECT EMPNO, ENAME, JOB, IFNULL(MGR, "") AS MGR, DATE_FORMAT(HIREDATE, "%d/%m/%y") AS HIREDATE, SAL, IFNULL(COMM, "") AS COMM, DEPTNO
FROM empleados
WHERE job = "CLERK";

-- 4. Idem, pero ordenado por el nombre.
SELECT EMPNO, ENAME, JOB, IFNULL(MGR, "") AS MGR, DATE_FORMAT(HIREDATE, "%d/%m/%y") AS HIREDATE, SAL, IFNULL(COMM, "") AS COMM, DEPTNO
FROM empleados
WHERE job = "CLERK"
ORDER BY ename;

-- 5. Obten el mismo resultado de la pregunta anterior, pero ahora ordenando sólo por deptno en sentido descendente:
SELECT EMPNO, ENAME, JOB, IFNULL(MGR, "") AS MGR, DATE_FORMAT(HIREDATE, "%d/%m/%y") AS HIREDATE, SAL, IFNULL(COMM, "") AS COMM, DEPTNO
FROM empleados
WHERE job = "CLERK"
ORDER BY deptno DESC;

-- 6. Obten el Obten (codigo), nombre y salario de los empleados.
SELECT EMPNO, ENAME, SAL
FROM empleados;

-- 7. Lista los nombres de todos los departamentos.
SELECT DNAME
FROM departamentos;

-- 8. Idem, pero ordenandolos por nombre.
SELECT DNAME
FROM departamentos
ORDER BY dname;

-- 9. Idem, pero ordenandolo por la ciudad (no se debe seleccionar la ciudad en el resultado).
SELECT DNAME
FROM departamentos
ORDER BY loc;

-- 10. Idem, pero el resultado debe mostrarse ordenado por la ciudad en orden inverso.
SELECT DNAME
FROM departamentos
ORDER BY loc DESC;

-- 11. Obtener el nombre y empleo de todos los empleados, ordenado por salario.
SELECT ENAME, JOB
FROM empleados
ORDER BY sal;

-- 12. Obtener el nombre y empleo de todos los empleados, ordenado primero por su trabajo y luego por su salario.
SELECT ENAME, JOB
FROM empleados
ORDER BY job, sal;

-- 13. Idem, pero ordenando inversamente por empleo y normalmente por salario.
SELECT ENAME, JOB
FROM empleados
ORDER BY job DESC, sal;

-- 14. Obten los salarios y las comisiones de los empleados del departamento 30.
SELECT SAL, IFNULL(COMM, "") AS COMM
FROM empleados
WHERE deptno = 30;

-- 15. Idem, pero ordenado por comision.
SELECT SAL, IFNULL(COMM, "") AS COMM
FROM empleados
WHERE deptno = 30
ORDER BY -comm DESC;

-- 16. (a) Obten las comisiones de todos los empleados.
SELECT IFNULL(COMM, "") AS COMM
FROM empleados;

-- 16. (b) Obten las comisiones de los empleados de forma que no se repitan.
SELECT DISTINCT IFNULL(COMM, "0") AS COMM
FROM empleados;

-- 17. Obten el nombre de empleado y su comision SIN FILAS repetidas.
SELECT DISTINCTROW ENAME, IFNULL(COMM, "") AS COMM
FROM empleados
ORDER BY ename; -- NO LO PIDE EL ENUNCIADO PERO EL RESULTADO ESTÁ ORDENADO ALFABÉTICAMENTE

-- 18. Obten los nombres de los empleados y sus salarios, de forma que no se repitan filas.
SELECT DISTINCTROW ENAME, SAL
FROM empleados
ORDER BY ename;

-- 19. Obten las comisiones de los empleados y sus Obtens de departamento, de forma que no serepitan filas.
SELECT DISTINCTROW IFNULL(COMM, "") AS COMMISSION, DEPTNO
FROM empleados
ORDER BY deptno, comm;

-- 20. Obten los nuevos salarios de los empleados del departamento 30, que resultar³an 
-- de sumar a su salario una gratificacion de 1000. Muestra tambien los nombres de los empleados.
SELECT ENAME, SAL+1000
FROM empleados
WHERE deptno = 30;

-- 21. Lo mismo que la anterior, pero mostrando tambien su salario original, y 
-- haz que la columna que almacena el nuevo salario se denomine NUEVO SALARIO.
SELECT ENAME, SAL, SAL+1000 AS NUEVO_SALARIO
FROM empleados
WHERE deptno = 30;

-- 22. Halla los empleados que tienen una comision superior a la mitad de su salario.
SELECT ENAME
FROM empleados
WHERE comm > (sal/2);

-- 23. Halla los empleados que no tienen comision, o que la tengan menor o igual que el 25% de su salario.
SELECT ENAME
FROM empleados
WHERE comm = 0 OR comm IS NULL OR comm <= (sal * 0.25);

-- 24. Obten una lista de nombres de empleados y sus salarios, de forma que en 
-- la salida aparezca en todas las filas \Nombre:" y \Salario:" antes del respectivo campo. 
SELECT CONCAT("Nombre:    ", ename) AS ENAME, CONCAT("Salario:    ", sal) AS SAL
FROM empleados;

-- 25. Hallar el codigo, salario y comision de los empleados cuyo codigo sea mayor que 7500.
SELECT EMPNO, SAL, IFNULL(COMM, "") AS COMM
FROM empleados
WHERE empno > 7500;

-- 26. Obten todos los datos de los empleados que esten a partir de la J, inclusive.
-- NOTA: Para ello usa la funcion left de PLMySql   
SELECT EMPNO, ENAME, JOB, IFNULL(MGR, "") AS MGR, DATE_FORMAT(HIREDATE, "%d/%m/%y") AS HIREDATE, SAL, IFNULL(comm,"") AS COMM, DEPTNO
FROM empleados
WHERE LEFT(ename, 1) >= 'j';

-- 27. Obten el salario, comision y salario total (salario+comision) de los empleados 
-- con comision, ordenando el resultado por numero de empleado.
SELECT SAL, COMM, (SAL+COMM) AS SALARIO_TOTAL
FROM empleados
WHERE NOT ISNULL(comm);

-- 28. Lista la misma informacion, pero para los empleados que no tienen comision.
SELECT SAL, IFNULL(COMM, "") AS COMM, IFNULL((SAL+COMM), "") AS SALARIO_TOTAL
FROM empleados
WHERE ISNULL(comm);

-- 29. Muestra el nombre de los empleados que, teniendo un salario superior 
-- a 1000, tengan como jefe al empleado cuyo codigo es 7698.
SELECT ENAME
FROM empleados
WHERE sal > 1000 AND mgr = 7698;

-- 30. Muestra el nombre de los empleados que, teniendo un salario inferior 
-- a 1000, no tengan como jefe al empleado cuyo codigo es 7698.
SELECT ENAME
FROM empleados
WHERE sal < 1000 AND mgr != 7698;

-- 31. Indica para cada empleado el porcentaje que supone su comision sobre su 
-- salario, ordenando el resultado por el nombre del mismo.
SELECT IFNULL((COMM*100)/(SAL+COMM), "") AS PORCENTAJE
FROM empleados
ORDER BY ename;

-- 32. Hallar los empleados del departamento 10 cuyo nombre no contiene la cadena LA.
SELECT ENAME
FROM empleados
WHERE ename NOT LIKE "%LA%" AND deptno = 10;

-- 33. Obten los empleados que no son supervisados por ningun otro.
SELECT ENAME
FROM empleados
WHERE mgr IS NULL;

-- 34. Obten los nombres de los departamentos que no sean Ventas (SALES) ni 
-- investigacion (RESEARCH). Ordena el resultado por la localidad del departamento.
SELECT DNAME
FROM departamentos
WHERE dname NOT IN ("sales", "research")
ORDER BY loc;

-- 35. Deseamos conocer el nombre de los empleados y el codigo del departamento 
-- de los administrativos(CLERK) que no trabajan en el departamento 10, y cuyo 
-- salario es superior a 800, ordenado por fecha de contratacion.
SELECT ENAME, DEPTNO
FROM empleados
WHERE job = "clerk" AND deptno != 10 AND sal > 800
ORDER BY hiredate;

-- 36. Para los empleados que tengan comision, obten sus nombres y el cociente entre 
-- su salario y su comision (excepto cuando la comision sea cero), ordenando el resultado por nombre.
SELECT ENAME, (SAL/COMM) AS COCIENTE
FROM empleados
WHERE NOT ISNULL(sal/comm)
ORDER BY ename;

-- 37. Lista toda la informacion sobre los empleados cuyo nombre completo tenga exactamente 5 caracteres.
SELECT EMPNO, ENAME, JOB, IFNULL(MGR, "") AS MGR, DATE_FORMAT(HIREDATE, "%d/%m/%y") AS HIREDATE, SAL, IFNULL(COMM, "") COMM, DEPTNO
FROM empleados
WHERE ename LIKE "_____";

-- 38. Lo mismo, pero para los empleados cuyo nombre tenga al menos cinco letras.
SELECT EMPNO, ENAME, JOB, IFNULL(MGR, "") AS MGR, DATE_FORMAT(HIREDATE, "%d/%m/%y") AS HIREDATE, SAL, IFNULL(COMM, "") COMM, DEPTNO
FROM empleados
WHERE ename LIKE "_____%";

-- 39. Halla los datos de los empleados que, o bien su nombre empieza por A y su 
-- salario es superior a 1000, o bien reciben comision y trabajan en el departamento 30.
SELECT EMPNO, ENAME, JOB, IFNULL(MGR, "") AS MGR, DATE_FORMAT(HIREDATE, "%d/%m/%y") AS HIREDATE, SAL, IFNULL(COMM, "") COMM, DEPTNO
FROM empleados
WHERE (ename LIKE "A%" AND sal > 1000) OR (comm > 0 AND deptno = 30);

-- 40. Halla el nombre, el salario y el sueldo total de todos los empleados, ordenando 
-- el resultado primero por salario y luego por el sueldo total. En el caso de que no 
-- tenga comision, el sueldo total debe reflejar solo el salario.
SELECT ENAME, SAL, SAL+IFNULL(COMM, 0) AS SALARIO_TOTAL
FROM empleados
ORDER BY sal, sal+IFNULL(comm, 0);

-- 41. Obten el nombre, salario y la comision de los empleados que perciben 
-- un salario que esta entre la mitad de la comision y la propia comision.
SELECT ENAME, SAL, IFNULL(COMM, "") AS COMM
FROM empleados
WHERE sal BETWEEN (comm/2) AND comm;

-- 42. Obten el nombre, salario y la comision de los empleados que perciben 
-- un salario complementario al caso 41: que sea superior a la comision o inferior a la mitad de la comision.
SELECT ENAME, SAL, IFNULL(COMM, "") AS COMM
FROM empleados
WHERE sal NOT BETWEEN (comm/2) AND comm;

-- 43. Lista los nombres y empleos de aquellos empleados cuyo empleo acaba 
-- en MAN y cuyo nombre empieza por A.
SELECT ENAME, JOB
FROM empleados
WHERE job LIKE "%MAN" AND ename LIKE "A%";

-- 44. Intenta resolver la pregunta anterior con un predicado simple, es decir, 
-- de forma que en la clausula WHERE no haya conectores logicos como AND, OR, etc. 
-- Si ayuda a resolver la pregunta, se puede suponer que el nombre del empleado tiene al menos cinco letras.
SELECT ENAME, JOB
FROM empleados
WHERE CONCAT(ename, job) REGEXP '^A.*MAN$';

-- 45. Halla los nombres de los empleados cuyo nombre tiene como maximo cinco caracteres.
/*SELECT ename
FROM empleados
WHERE ename REGEXP "^$|^.$|^..$|^...$|^....$|^.....$";*/

SELECT ENAME
FROM empleados
WHERE LENGTH(ename) <= 5; 

-- 46. Suponiendo que el a~no proximo la subida del sueldo total de cada empleado sera del 60 %, 
-- y el siguiente del 70 %, halla los nombres y el salario total actual, del a~no proximo y del 
-- siguiente, de cada empleado. Indique ademas con SI o NO, si el empleado tiene comision. 

SELECT 
	ENAME, 
    (	CASE
			WHEN COMM > 0 THEN 'SI'
			WHEN COMM = 0 THEN 'NO'
            WHEN COMM IS NULL THEN 'NOSESABE'
		END
	) AS COMM,
    IFNULL(SAL+COMM, SAL) AS SALARIO_TOTAL, 
    IFNULL(SAL+COMM, SAL)*1.6 AS SALARIO_DEL_PROXIMO_AÑO, 
    (IFNULL(SAL+COMM, SAL)*1.6)*1.7 AS SALARIO_DEL_SIGUIENTE_AÑO
FROM empleados
ORDER BY ename;

-- 47. Lista los nombres y fecha de contratacion de aquellos empleados que no son vendedores (SALESMAN).
SELECT ENAME, DATE_FORMAT(HIREDATE, "%d/%m/%y") AS HIREDATE
FROM empleados
WHERE job!="salesman";

/* 48. Obten la informacion disponible de los empleados cuyo numero es uno de los 
siguientes: 7844, 7900, 7521, 7521, 7782, 7934, 7678 y 7369, pero que no sea uno 
de los siguientes: 7902, 7839, 7499 ni 7878. La sentencia no debe complicarse 
innecesariamente, y debe dar el resultado correcto independientemente de lo 
empleados almacenados en la base de datos.*/
SELECT EMPNO, ENAME, JOB, IFNULL(MGR, "") AS MGR, DATE_FORMAT(HIREDATE, "%d/%m/%y") AS HIREDATE, SAL, IFNULL(COMM, "") AS COMM, DEPTNO
FROM empleados
WHERE 
	empno IN (7844, 7900, 7521, 7782, 7934, 7678, 7369) 
	AND empno NOT IN (7902, 7839, 7499, 7878);
    
-- 49. Ordena los empleados por su codigo de departamento, y luego de manera descendente por su numero de empleado.
SELECT EMPNO, ENAME, JOB, IFNULL(MGR, "") AS MGR, DATE_FORMAT(HIREDATE, "%d/%m/%y") AS HIREDATE, SAL, IFNULL(COMM, "") AS COMM, DEPTNO
FROM empleados
ORDER BY deptno, empno DESC;

-- 50. Para los empleados que tengan como jefe a un empleado con codigo mayor que 
-- el suyo, obten los que reciben de salario mas de 1000 y menos de 2000, o que estan en el departamento 30.
SELECT ENAME
FROM empleados
WHERE
	mgr > empno AND 
    (sal > 1000 AND sal < 2000 OR 
    deptno = 30);
    
-- 51. Obten el salario mas alto de la empresa, el total destinado a 
-- comisiones y el numero de empleados.
SELECT MAX(SAL), SUM(IFNULL(COMM, 0)) AS 'SUM(COMM)', COUNT(*)
FROM empleados; 

-- 52. Halla los datos de los empleados cuyo salario es mayor que el del empleado de codigo 7934, ordenando por el salario.
SELECT EMPNO, ENAME, JOB, IFNULL(MGR, "") AS MGR, DATE_FORMAT(HIREDATE, "%d/%m/%y") AS HIREDATE, SAL, IFNULL(COMM, "") AS COMM, DEPTNO
FROM empleados
WHERE sal > (SELECT sal FROM empleados WHERE empno = 7934)
ORDER BY sal;

-- 53. Obten informacion en la que se reflejen los nombres, empleos y salarios tanto de 
-- los empleados que superan en salario a Allen como del propio Allen.
SELECT e.ENAME, e.JOB, e.SAL
FROM empleados e
WHERE e.sal >= (SELECT e.sal FROM empleados e WHERE e.ename="Allen");

-- 54. Halla el nombre el ultimo empleado por orden alfabetico.
SELECT MAX(e.ename) AS 'MAX(ENAME)'
FROM empleados e;

-- 55. Halla el salario mas alto, el mas bajo, y la diferencia entre ellos.
SELECT MAX(e.SAL) SAL_MAS_ALTO, MIN(e.sal) SAL_MAS_BAJO, (MAX(e.SAL) - MIN(e.SAL)) DIFERENCIA
FROM empleados e;

-- 56. Sin conocer los resultados del ejercicio anterior, Â¿quienes reciben el 
-- salario mas alto y el mas bajo, y a cuanto ascienden estos salarios?
SELECT e.ENAME, e.SAL
FROM empleados e
WHERE 
	e.sal = (SELECT MAX(e.sal) FROM empleados e) OR 
	e.sal = (SELECT MIN(e.sal) FROM empleados e)
ORDER BY e.ename;
    
-- 57. Considerando empleados con salario menor de 5000, halla la media de los salarios 
-- de los departamentos cuyo salario minimo supera a 900. Muestra tambien el codigo y 
-- el nombre de los departamentos.
SELECT d.DNAME, AVG(e.SAL) AS 'AVG(A.SAL)'
FROM empleados e
INNER JOIN departamentos d
ON e.deptno = d.deptno
WHERE e.sal < 5000 
GROUP BY d.dname
HAVING MIN(e.sal) > 900;

-- e.deptno NOT IN (SELECT e.deptno FROM empleados e WHERE e.sal < 900)


-- 58. Â¿Que empleados trabajan en ciudades de mas de cinco letras? Ordena el resultado 
-- inversamente por ciudades y normalmente por los nombres de los empleados.
SELECT e.ENAME
FROM empleados e
INNER JOIN departamentos d
ON e.deptno = d.deptno
WHERE LENGTH(d.loc) > 5
ORDER BY d.loc DESC, e.ename ASC;

-- 59. Halla los empleados cuyo salario supera o coincide con la media del salario de la empresa.
SELECT e.ENAME
FROM empleados e
WHERE e.sal >= (SELECT AVG(e.sal) from empleados e);

-- 60. Obten los empleados cuyo salario supera al de sus compa~neros de departamento.
/*SELECT e.ename
FROM empleados e
WHERE e.sal IN (SELECT MAX(e.sal) FROM empleados e GROUP BY e.deptno)
GROUP BY e.deptno;*/

SELECT e.ENAME
FROM empleados e
WHERE CONCAT(e.sal, e.deptno) IN (SELECT CONCAT(MAX(e.sal), e.deptno) FROM empleados e GROUP BY e.deptno);

-- 61. Â¿Cuantos empleos diferentes, cuantos empleados, y cuantos salarios diferentes 
-- encontramos en el departamento 30, y a cuanto asciende la suma de salarios de dicho departamento?
SELECT COUNT(DISTINCT e.JOB) AS NUM_JOB, COUNT(e.EMPNO) AS NUM_EMP, COUNT(DISTINCT e.SAL) AS NUM_SAL, SUM(e.SAL) AS 'SUM(SAL)'
FROM empleados e
WHERE e.deptno = 30;

-- 62. Â¿Cuantos empleados tienen comision?
SELECT COUNT(*)
FROM empleados e
WHERE e.comm > 0;

-- 63. Â¿Cuantos empleados tiene el departamento 20?
SELECT COUNT(e.EMPNO) AS NUM_EMP
FROM empleados e
WHERE e.deptno = 20;

-- 64. Halla los departamentos que tienen mas de tres empleados, y el numero de empleados de los mismos.
SELECT e.DEPTNO, COUNT(e.EMPNO) AS NUM_EMP
FROM empleados e
GROUP BY e.deptno
HAVING num_emp > 3;

-- 65. Obten los empleados del departamento 10 que tienen el mismo empleo que 
-- alguien del departamento de Ventas. Desconocemos el codigo de dicho departamento.
SELECT e.ENAME
FROM empleados e
WHERE e.deptno = 10 AND e.job IN (SELECT e.job 
								FROM empleados e 
                                INNER JOIN departamentos d
								ON e.deptno = d.deptno
								WHERE d.dname = "sales");

-- 66. Halla los empleados que tienen por lo menos un empleado a su mando, ordenados inversamente por nombre.
SELECT e.ENAME
FROM empleados e
WHERE e.empno IN (SELECT e.mgr FROM empleados e)
ORDER BY e.ename DESC;

-- 67. Obten informacion sobre los empleados que tienen el mismo trabajo que 
-- algun empleado que trabaje en Chicago.
SELECT e.EMPNO, e.ENAME, e.JOB, IFNULL(e.MGR, "") AS MGR, DATE_FORMAT(e.HIREDATE, "%d/%m/%y") AS HIREDATE, e.SAL, IFNULL(e.COMM, "") AS COMM, e.DEPTNO
FROM empleados e
WHERE e.job IN (SELECT DISTINCT e.job 
				FROM empleados e 
                INNER JOIN departamentos d
				ON e.deptno = d.deptno
                WHERE loc = "chicago")
ORDER BY e.job;

-- 68. Â¿Que empleos distintos encontramos en la empresa, y cuantos empleados desempeÃ±an cada uno de ellos?
SELECT e.JOB, COUNT(*)
FROM empleados e
GROUP BY e.job
ORDER BY e.job;

-- 69. Halla la suma de salarios de cada departamento.
SELECT d.DNAME, SUM(e.sal) AS 'SUM(SAL)'
FROM departamentos d
INNER JOIN empleados e
ON d.deptno = e.deptno
GROUP BY d.dname
ORDER BY d.dname;

-- 70. Obten todos los departamentos sin empleados.
SELECT d.DNAME
FROM departamentos d
WHERE d.deptno NOT IN (SELECT DISTINCT e.deptno
						FROM empleados e);
                        
-- 71. Halla los empleados que no tienen a otro empleado a sus ordenes.
SELECT e.ENAME
FROM empleados e
WHERE e.empno NOT IN (SELECT DISTINCT IFNULL(e.mgr, "") FROM empleados e);

-- 72. Â¿Cuantos empleados hay en cada departamento, y cual es la media anual 
-- del salario de cada uno (el salario almacenado es mensual)? 
-- Indique el nombre del departamento para clarificar el resultado.
SELECT d.DNAME, AVG(e.sal) AS 'AVG(SAL)', COUNT(*)
FROM departamentos d
INNER JOIN empleados e
ON d.deptno = e.deptno
GROUP BY d.dname
ORDER BY d.dname;

-- 73. Halla los empleados del departamento 30, por orden descendente de comision
SELECT e.ENAME
FROM empleados e
WHERE e.deptno = 30
ORDER BY comm DESC;
					-- NULL no és un valor así que no puede quedar en la parte superior como en la respuesta propuesta. 

-- 74. Obten los empleados que trabajan en Dallas o New York.
SELECT e.ENAME
FROM empleados e
INNER JOIN departamentos d
ON d.deptno = e.deptno
WHERE loc IN ("Dallas", "New York");

-- 75. Obten un listado en el que se reflejen los empleados y los nombres 
-- de sus jefes. En el listado deben aparecer todos los empleados, aunque no 
-- tengan jefe, poniendo un nulo el nombre de este.
/*SELECT e.ENAME, em.ENAME
FROM empleados e
INNER JOIN empleados em
ON e.empno = em.empno
WHERE em.ename = e.mgr;*/



-- 76. Lista los empleados que tengan el mayor salario de su departamento, 
-- mostrando el nombre del empleado, su salario y el nombre del departamento.
SELECT e.ENAME, e.SAL, d.DNAME
FROM empleados e
INNER JOIN departamentos d
ON e.deptno = d.deptno
WHERE CONCAT(e.sal, e.deptno) IN (SELECT CONCAT(MAX(e.sal), e.deptno) FROM empleados e GROUP BY e.deptno)
ORDER BY e.sal;

/* 77. Deseamos saber cuantos empleados supervisa cada jefe. Para ello, obten un listado 
en el que se reflejen el codigo y el nombre de cada jefe, junto al numero de empleados 
que supervisa directamente. Como puede haber empleados sin jefe, para estos se indicara 
solo el numero de ellos, y los valores restantes (codigo y nombre del jefe) se dejaran como nulos. */
/*SELECT e.ENAME, e.EMPNO, COUNT(DISTINCT e.MGR), e.MGR
FROM empleados e
GROUP BY e.MGR;*/

-- 78. Hallar el departamento cuya suma de salarios sea la mas alta, mostrando esta 
-- suma de salarios y el nombre del departamento
SELECT d.DNAME, SUM(e.SAL) AS 'SUM(SAL)'
FROM departamentos d
INNER JOIN empleados e
ON d.deptno = e.deptno
GROUP BY d.dname
HAVING SUM(e.SAL) = (SELECT SUM(e.sal)
					FROM departamentos d
                    INNER JOIN empleados e
                    ON d.deptno = e.deptno
                    GROUP BY d.dname
                    ORDER BY SUM(e.sal) DESC
                    LIMIT 1);

-- 79. Obten los datos de los empleados que cobren los dos mayores salarios de la empresa. 
-- (Nota: Procure hacer la consulta de forma que sea facil obtener los empleados de los N mayores salarios)
SELECT e.EMPNO, e.ENAME, e.JOB, IFNULL(e.MGR, "") AS MGR, DATE_FORMAT(e.HIREDATE, "%d/%m/%y") AS HIREDATE, e.SAL, IFNULL(e.COMM, "") AS COMM, e.DEPTNO
FROM empleados e 
WHERE 	e.sal = (SELECT MAX(e.SAL) FROM empleados e) OR 
		e.sal = (SELECT MAX(e.SAL) FROM empleados e WHERE e.sal < (SELECT MAX(e.SAL) FROM empleados e))
ORDER BY e.sal DESC;


/*SELECT e.EMPNO, e.ENAME, e.JOB, IFNULL(e.MGR, "") AS MGR, DATE_FORMAT(e.HIREDATE, "%d/%m/%y") AS HIREDATE, e.SAL, IFNULL(e.COMM, "") AS COMM, e.DEPTNO
FROM empleados e 
ORDER BY e.sal DESC
LIMIT 2;*/
/*SELECT e.EMPNO, e.ENAME, e.JOB, IFNULL(e.MGR, "") AS MGR, DATE_FORMAT(e.HIREDATE, "%d/%m/%y") AS HIREDATE, e.SAL, IFNULL(e.COMM, "") AS COMM, e.DEPTNO
FROM empleados e 
WHERE e.sal = 	(SELECT e.SAL
				FROM empleados e
				ORDER BY e.sal DESC
				LIMIT 2,1);*/


/* 80. Obten las localidades que no tienen departamentos sin empleados y en las que 
trabajen al menos cuatro empleados. Indica tambien el numero de empleados que trabajan 
en esas localidades. (Nota: Por ejemplo, puede que en A Coru~na existan dos departamentos, 
uno con mas de cuatro empleados y otro sin empleados, en tal caso, A Coru~na no debe 
aparecer en el resultado, puesto que tiene un departamento SIN EMPLEADOS, a pesar de tener 
otro con empleados Y tener mas de cuatro empleados EN TOTAL. 
ATENCION, la restriccion de que tienen que ser cuatro empleados se refiere a la totalidad 
de los departamentos de la localidad.) */