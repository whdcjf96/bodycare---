// 사용자 모델 정의
// 인증을 위한 사용자 모델
export default class User3 {
  constructor(name, password,gender,height,age, weight,bodyFat,muscleMass,kcalStart,kcalWeekly,fatGoal) {
    this.name = name;
    this.password = password;
    this.gender = gender;
    this.height = height;
    this.age=age;
    this.weight = weight;
    this.bodyFat= bodyFat;
    this.muscleMass=muscleMass;
    this.kcalStart= kcalStart;
    this.kcalWeekly=kcalWeekly;
    this.fatGoal=fatGoal;
  }
}
