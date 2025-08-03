import React, { useState } from "react";
import { signinUser } from "../api/userApi";
import { apiSubmit } from '../common/apiSubmit';

function RootPage() {
    const [formData, setFormData] = React.useState({
            userId: "",
            password: ""
        });

        const [logginedInUser, setLogginedInUser] = useState({ userId: "" });
    
        const handleChange = (e) => {
            setFormData({ ...formData, [e.target.name]: e.target.value });
        };
    
        const handleSubmit = async (e) => {
            e.preventDefault();
    
            await apiSubmit('signin', signinUser, formData, {
    
                submit_signin_callback: (res) => {
                    alert(res.message);
                    setLogginedInUser(res.data);
                    setFormData({
                        userId: "",
                        password: "",
                });
            },
                submit_signin_exception: (res) => {
                    alert(res.message || '로그인 중 오류가 발생했습니다.');
                }
            });
        };

    return (
        <div style={{ maxWidth: "400px", margin: "50px auto" }}>
            <h2>Root Page</h2>
            <p>Welcome to the root page!</p>
            {logginedInUser.userId ? (
                <div>
                    {logginedInUser.userId}님 환영합니다
                    <button style={{ marginLeft: "10px" }} onClick={() => setLogginedInUser({ userId: "" })}>로그아웃</button>
                </div>
            ) : (
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
                <button type="submit">로그인하기</button>
            </form>
            )}
            
        </div>
        
    );
}

export default RootPage;