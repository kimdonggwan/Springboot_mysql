import React, { useState } from "react";
import { signupUser } from "../api/userApi";
import { apiSubmit } from '../common/apiSubmit';

function SignupForm() {

    const [formData, setFormData] = useState({
        userId: "",
        password: "",
        confirmPassword: "",
        name: "",
        phone: ""
    });

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (formData.password !== formData.confirmPassword) {
            alert("비밀번호가 일치하지 않습니다.");
            return;
        }

        await apiSubmit('signup', signupUser, formData, {

            submit_signup_callback: (res) => {
                alert(res.message);
                setFormData({
                    userId: "",
                    password: "",
                    confirmPassword: "",
                    name: "",
                    phone: ""
            });
        },
            submit_signup_exception: (res) => {
                alert(res.message || '회원 가입 중 오류가 발생했습니다.');
            }
        });
    };

    return (
        <form onSubmit={handleSubmit}>
            <input
                name="userId"
                placeholder="아이디"
                value={formData.userId}
                onChange={handleChange}
                required
            /><br />
            <input
                type="password"
                name="password"
                placeholder="비밀번호"
                value={formData.password}
                onChange={handleChange}
                required
            /><br />
            <input
                type="password"
                name="confirmPassword"
                placeholder="비밀번호 확인"
                value={formData.confirmPassword}
                onChange={handleChange}
                required
            /><br />
            <input
                name="name"
                placeholder="이름"
                value={formData.name}
                onChange={handleChange}
                required
            /><br />
            <input
                name="phone"
                placeholder="전화번호"
                value={formData.phone}
                onChange={handleChange}
                required
            /><br />
            <button type="submit">가입하기</button>
        </form>
    );
}

export default SignupForm;