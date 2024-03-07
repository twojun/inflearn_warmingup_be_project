# Inflearn Warming-up Club Back-end Mini Project Summary 

## 1. 진행 상황 </br>
P1 ✅ (완료) </br>
P2 ✅ (완료) </br>
P3 ... 진행 중  </br>
P4 ... 진행 중  </br></br></br>



## P1. 팀, 직원 등록 & 조회
### 1-1. Code
- [UserEntity](https://github.com/twojun/inflearn_warmingup_be_project/blob/master/src/main/java/com/example/inflearn_warmingup_project/domain/user/User.java)
- [UserController](https://github.com/twojun/inflearn_warmingup_be_project/blob/master/src/main/java/com/example/inflearn_warmingup_project/controller/user/UserController.java)
- [UserService](https://github.com/twojun/inflearn_warmingup_be_project/blob/master/src/main/java/com/example/inflearn_warmingup_project/service/user/UserService.java)
- [UserRepository](https://github.com/twojun/inflearn_warmingup_be_project/blob/master/src/main/java/com/example/inflearn_warmingup_project/repository/user/UserRepository.java)

- [TeamEntity](https://github.com/twojun/inflearn_warmingup_be_project/blob/master/src/main/java/com/example/inflearn_warmingup_project/domain/team/Team.java)
- [TeamController](https://github.com/twojun/inflearn_warmingup_be_project/blob/master/src/main/java/com/example/inflearn_warmingup_project/controller/team/TeamController.java)
- [TeamService](https://github.com/twojun/inflearn_warmingup_be_project/blob/master/src/main/java/com/example/inflearn_warmingup_project/service/team/TeamService.java)
- [TeamRepository](https://github.com/twojun/inflearn_warmingup_be_project/blob/master/src/main/java/com/example/inflearn_warmingup_project/repository/team/TeamRepository.java) </br></br></br></br>



### 1-2. 테스트 
(1) 직원 등록 후 조회 
![image](https://github.com/twojun/inflearn_warmingup_be_project/assets/118627166/39adb64f-37fd-4229-9029-f31ffc82b4c1)</br>
<img width="818" alt="image" src="https://github.com/twojun/inflearn_warmingup_be_project/assets/118627166/ea74f822-6265-452e-928a-c464883a3ce1"> </br>
<img width="785" alt="image" src="https://github.com/twojun/inflearn_warmingup_be_project/assets/118627166/236bfe34-2fd0-4d25-baa1-d27224f24b82"> </br></br></br>




(2) 팀 등록 후 조회</br>
![image](https://github.com/twojun/inflearn_warmingup_be_project/assets/118627166/ad335bfe-ac6d-4ef6-b264-a0c6a0f59234)</br>
<img width="771" alt="image" src="https://github.com/twojun/inflearn_warmingup_be_project/assets/118627166/396cd126-1362-426f-bb35-423e254fe351"></br>
<img width="756" alt="image" src="https://github.com/twojun/inflearn_warmingup_be_project/assets/118627166/292d0df7-8053-4d5e-b41f-b660d247498c"></br></br></br></br></br>






## P2. 출/퇴근 등록 & 월 근무시간 조회 
### 2-1. Code 
- [Attendance](https://github.com/twojun/inflearn_warmingup_be_project/blob/master/src/main/java/com/example/inflearn_warmingup_project/domain/attendance/Attendance.java)
- [AttendanceController](https://github.com/twojun/inflearn_warmingup_be_project/blob/master/src/main/java/com/example/inflearn_warmingup_project/controller/attendance/AttendanceController.java)
- [AttendanceService](https://github.com/twojun/inflearn_warmingup_be_project/blob/master/src/main/java/com/example/inflearn_warmingup_project/service/attendance/AttendanceService.java)
- [AttendanceRepository](https://github.com/twojun/inflearn_warmingup_be_project/blob/master/src/main/java/com/example/inflearn_warmingup_project/repository/attendance/AttendanceRepository.java)</br></br></br>


### 2-2. 테스트  </br>
(1) 직원이 출근하여 퇴근까지 찍은 경우 하루에 일한 시간이 분으로 저장되고, 일수마다 allWorkingMinutes가 누적된다.
출근한 상태에서는 is_status는 1이며 퇴근까지 하게 되면 is_status가 0으로 바뀌게 된다.
![image](https://github.com/twojun/inflearn_warmingup_be_project/assets/118627166/31c46213-edc1-4592-a16e-43d5dab53d37)</br></br></br>


(2) 특정 직원의 날짜별 근무시간 조회하기
- 현재 ID = 1, 4인 직원이 아래와 같이 존재할 때 1번 직원과 4번 직원의 2월 근무시간의 총합을 받아오는 API이다.</br>
<img width="751" alt="image" src="https://github.com/twojun/inflearn_warmingup_be_project/assets/118627166/f0e7c404-dc65-4f77-826e-b5ad305b5d03"></br>

- 4번 직원의 근무 시간 총합도 확인해 보자.</br>
<img width="738" alt="image" src="https://github.com/twojun/inflearn_warmingup_be_project/assets/118627166/4d84693e-c499-478a-a10a-328b6db4acd0"> </br></br></br></br></br>





## P3. 연차 등록 / 월 근무시간 조회 (연차를 사용했다면 연차정보 반영되어야 함)
### 3-1. Code </br></br>




### 3-2. 테스트 </br>
(1) 올해 입사자의 연차 등록</br>
![image](https://github.com/twojun/inflearn_warmingup_be_project/assets/118627166/522374ed-7c4e-4467-89dc-877c25ede543) </br></br></br>


(2) 특정 직원 연차 조회</br>
<img width="674" alt="image" src="https://github.com/twojun/inflearn_warmingup_be_project/assets/118627166/c00f0af1-4226-4cc1-a0a2-09323e8db096"></br></br></br></br></br></br>





## P4. 직원의 초과근무 시간 계산
### 4-1. Code </br></br>


### 4-2. 테스트


