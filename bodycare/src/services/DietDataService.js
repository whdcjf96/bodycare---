// axios 사용법
// ex) get방식 : axios.get('/user/12345')
//     post방식 : axios.post('/user',{id:'aa',name:'forbob'})
//    axios : get, post, put, delete
//    axios.post('/user,{id:'aa',name:'forbob'})
//    .then(function(res) {
//   성공하면 then 들어옴
//     })
//    .catch(function(error) {
//  실패하면 catch 들어옴
// })
import http from "../http-common";

// 자바스크립트 class
class DietDataService {
    // tutorials 전체 목록 조회 메소드
    // axios -> spring 데이터 요청 -> spring -> db -> 결과 반환
    getAllDiets(params) {
        return http.get("/diets", {params});
    }
    getUserDiets(id) {
        return http.get(`/diets/${id}`);
    }
    getUserDietById(userId,dietDate){
        return http.get(`/userDiets/userId/${userId}/dietDate/${dietDate}`);
    }

    // customer 데이터 추가 메소드(insert 문 호출)
    insertDiets(data) {
        return http.post("/diets", data);
    }
    // insertUserDiets(data) {
    //     return http.post("/userDiets", data);
    // }
    createUserDiet(data) {
        return http.post("/userDiets", data);
    }
    updateUserDiet(id, data) {
        return http.put(`/userDiets/${id}`, data);
    }
    

    deleteDiet(userId,id) {
        return http.delete(`/diets/userId/${userId}/id/${id}`);
    }
}
// export : 모듈을 다른 자바스크립트 파일에서 참조함
// new 모듈명 : class 객체생성을 위해 new 사용함
export default new DietDataService();
