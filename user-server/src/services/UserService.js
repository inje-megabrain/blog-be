'use strict';

const db = require('@/config/sequalize');

/**
 * 유저와 관련된 서비스를 처리하는 클래스.
 * 모든 함수는 static이므로 new로 생성하지 말 것.
 */
class UserService {
  /**
   * 로그인 토큰을 발급합니다.
   * @param {string} id 아이디
   * @param {string} pw 비밀번호(raw)
   * @returns {Promise<{token: string, session_id: string}>} 토큰
   * @todo
   */
  static async login(id, pw) {
    throw new Error("구현되지 않았습니다.");
  }

  /**
   * 회원가입 합니다.
   * @param {User} newUser 신규 회원 정보가 포함된 User 객체
   * @returns {Promise<boolean>} 성공 여부
   * @todo
   */
  static async signup(newUser) {
    throw new Error("구현되지 않았습니다.");
  }

  /**
   * ID를 찾습니다.
   * @param {string} email 
   * @param {string} name 
   * @returns 
   */
  static async findId(email, name) {
    throw new Error("구현되지 않았습니다.");
  }

  /**
   * 비밀번호를 변경합니다.
   * @param {string} id 
   * @param {string} newPassword
   * @returns 
   */
  static async changePassword(id, newPassword) {
    throw new Error("구현되지 않았습니다.");
  }

  /**
   * 회원 탈퇴합니다.
   * @param {string} id 
   * @returns 
   */
  static async resign(id) {
    throw new Error("구현되지 않았습니다.");
  }

  /**
   * 사용자 전체를 조회합니다.
   * @returns {Promise<{id: string, name: string, email: string}[]>} 유저 DTO 배열
   */
  static async findAll() {
    throw new Error("구현되지 않았습니다.");
  }

  /**
   * 사용자 정보를 가져옵니다.
   * @param {string} id
   */
  static async getInfo(id) {
    throw new Error("구현되지 않았습니다.");
  }

  /**
   * 사용자 정보를 수정합니다. (근데 어떤 정보?)
   * @param
   * @todo id, password 등 수정할 수 없는 data가 없는지 검사
   */
  static async changeInfo(id) {
    throw new Error("구현되지 않았습니다.");
  }
}

module.exports = UserService;