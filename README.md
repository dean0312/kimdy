# kimdy
김동영의 프로젝트

excelview 작업과정)

excel로 화면 출력을 하기위해서 

controller, serviceFacade, applicationservice, dao , sqlmap ,bean 을만들고 

applicationContext,servlet에 urlhandler 와 bean을 생성.

그후 ModelAndView 에 view 로 사용할 excelview 소스를 짤것이다.

excelview.java 는 common패키지의 view 폴더에 생성할것이다.

1.excelview 만듬

2.excelview로 만들어질 excel화면에 뿌려줄 데이터 수정 (쿼리수정)

        SELECT DISTINCT  S.SLIP_NO as slipNo,

                         D.DEPT_NAME AS deptname,
                                
                         S.EXPENSE_REPORT as expenseReport,
                                
                         S.SLIP_TYPE as slipType,
                                
                         S.SLIP_STATUS as slipStatus,
                                
                         S.REPORTING_DATE as reportingDate,
                                
                         S.ACCOUNT_PERIOD_NO as accountPeriodNo,
                                
                   	     E.EMP_NAME AS empname
                                
    FROM SLIP S,
  
             JOURNAL J,
             
             Employee E,
             
             DEPARTMENT D  
             
        WHERE S.SLIP_NO = J.SLIP_NO
        
    		AND E.EMP_CODE=S.REPORTING_EMP_CODE
        
    		AND D.DEPT_CODE=S.DEPT_CODE
        
        AND S.REPORTING_DATE BETWEEN '2019-10-01' AND '2019-10-13'
        
        ORDER BY S.REPORTING_DATE
        
        
3.bean 도 그에맞게 바꾸고 sqlmap 작업

4.excelview class에 bean에맞게 label list 입력

5.applicationContext.xml 에 excelview bean(id,class)등록 

6.ModelAndView에 excelview 적용 DAO에서받아온 model도같이 보내기

excelview 소스는 common.view 폴더 참고

--------------------------------------------------------------
2019.11.18
