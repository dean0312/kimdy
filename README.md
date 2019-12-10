
김동영의 프로젝트

2019.11.18
-----------------------------------------------------------------------


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



2019.12.10
--------------------------------------------------------------------------
4차 스프링 부트,마이바티스로 변경하는 작업을 진행했다.

xml파일들을 다 제거해보면서 springboot 와 spring 의 차이점을 공부했고,

기본 업무인 전표 분개 분개상세 쪽 버그를 해결하였다.

그리고 아이바티스에서 마이바티스로 변경하면서 태그안 속성값 ,동적태그등이 신택스가 틀려서 모두 갈아엎었고

mybatisConfig 파일, mybatis.type-aliases-package같은 설정파일들을 사용해보았다.

매핑은 simpleurlhandlermapping에서 언어테이션 매핑으로 변경하였고

그로인해 requestmapping의 주소를 컨트롤러가아닌 메서드에 매핑을하고 restAPI를 사용해

url요청들을 restFul하게 변경했고 

기존에 메서드명을 request.parameter로 받아와서 multiactioncontroller로 작업을 거치지않고 바로 메서드로 매핑을했기때문에

작업이 더 수월했고 코드도 간결했다.

그리고 기존 log4g 의 사용법을 잘몰랐는데 로그가 찍히는건알고있었다.

이번에 logback-spring 과  log4jdbc.log4j2 를 사용하여 url 요청시에 작업이 어떻게 이루어지는지, 에러가 발생하는시점, 

DB커넥션할때 값은잘받아오는지를 console에 찍어주게되어 조금더 편리하게 버그해결을 할수있었다.

그리고 기존 프로젝트에는 ModelAndView 를 사용해 모델과 뷰를 각각처리해서 다음 화면과 사용할 view를 정의했는데,

이번엔 responsebody+controller인 

RestController으로 ModelAndView를 사용하지않고 리턴시 바로 컬렉션객체들이나 빈들을 넘겨주고 그것을 바로 json객체로변환해 화면으로

넘겨주는 방식을 사용했다

설명을하자면 @responsebody 를 사용한 메서드나 컨트롤러들은 return시 그값을 자동으로 json객체로 변환하여 다음화면에 모델을 던져주게된다.

그렇기때문에 이때까지 사용했던 [ModelAndView("jsonview") : 컬렉션이나 빈을 json객체로 변환시켜주는 view]를 모두없앤뒤

return 퍼사드.메서드(); 로 코드가 많이 간결해졌다.

반대로 url에서 요청했을때 받아온 json객체를 컬렉션이나 빈에 담는 @requestBody도 있었다.

requestbody 같은경우는 객체를 한번에 받아오는개념이라 2번나눠서 받아서 2가지 빈이나 컬렉션에 담을수없다. (요청당 1회사용가능)

그리고 마지막으로 springbootapp을 사용했기때문에 tomcat 서버는 필요가없었고

차이점은 springbootapp 서버가 훨 ~신 빨랐다.



