// src/pages/SignupPage.js
import React from "react";
import SignupForm from "../components/SignupForm";

function SignupPage() {
    return (
        <div style={{ maxWidth: "400px", margin: "50px auto" }}>
            <h2>회원가입</h2>
            <SignupForm />
        </div>
    );
}

export default SignupPage;