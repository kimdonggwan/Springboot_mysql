import React, { useEffect, useState } from 'react';
import './App.css';

function App() {
  const [users, setUsers] = useState([]);
  const [newUser, setNewUser] = useState({ name: '', nickname: '' });

  // 1. 사용자 목록 불러오기
  const fetchUsers = () => {
    fetch('/api/users')
      .then((res) => res.json())
      .then((data) => setUsers(data))
      .catch((err) => console.error("사용자 불러오기 실패:", err));
  };

  useEffect(() => {
    fetchUsers();
  }, []);

  // 2. 사용자 추가
  const addUser = () => {
    fetch('/api/users', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(newUser),
    })
      .then(() => {
        setNewUser({ name: '', nickname: '' });
        fetchUsers(); // 목록 갱신
      });
  };

  // 3. 사용자 삭제
  const deleteUser = (id) => {
    fetch(`/api/users/${id}`, {
      method: 'DELETE',
    }).then(() => fetchUsers());
  };

  // 4. 사용자 이름 변경 (nickname은 그대로)
  const updateUser = (id, newName) => {
    const user = users.find((u) => u.id === id);
    const updated = { ...user, name: newName };

    fetch(`/api/users/${id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(updated),
    }).then(() => fetchUsers());
  };

  return (
    <div className="App">
      <h1>👤 사용자 목록</h1>
      <ul>
        {users.map((user) => (
          <li key={user.id}>
            {user.name} ({user.nickname}){' '}
            <button onClick={() => deleteUser(user.id)}>삭제</button>{' '}
            <button onClick={() => updateUser(user.id, prompt("새 이름:", user.name))}>수정</button>
          </li>
        ))}
      </ul>

      <h2>➕ 새 사용자 추가</h2>
      <input
        type="text"
        placeholder="이름"
        value={newUser.name}
        onChange={(e) => setNewUser({ ...newUser, name: e.target.value })}
      />
      <input
        type="text"
        placeholder="닉네임"
        value={newUser.nickname}
        onChange={(e) => setNewUser({ ...newUser, nickname: e.target.value })}
      />
      <button onClick={addUser}>추가</button>
    </div>
  );
}

export default App;
/*
function App() {
  const [users, setUsers] = useState([]);
  const [newUsers, setNewUsers] = useState({name:'',nicknamee:''});
  const [travellocations, setTravellocations] = useState([]);

  useEffect(() => {
    fetch("/api/users")  // 백엔드(Spring Boot)의 @GetMapping("/users") 경로
      .then((res) => res.json())
      .then((data) => {
        console.log("사용자 데이터:", data);
        if (Array.isArray(data)) {
          setUsers(data);
        } else if (data.users && Array.isArray(data.users)) {
          setUsers(data.users);
        } else {
          console.error("유효한 사용자 배열이 아닙니다.");
        }
      })
      .catch((err) => console.error("에러 발생:", err));

    fetch("/api/travellocations")
      .then((res) => res.json())
      .then((data) => {
        console.log("여행지 데이터:", data);
        if (Array.isArray(data)) {
          setTravellocations(data)
        } else if (data.travellocations && Array.isArray(data.travellocations)) {
          setTravellocations(data.travellocations);
        } else {
          console.error("유효한 여행지 배열이 아닙니다.");
        }
      })
      .catch((err) => console.error("여행지 에러 발생:", err));

  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <h1>사용자 목록</h1>
        {users.length === 0 ? (
          <p>불러오는 중...</p>
        ) : (
          <ul>
            {users.map((user, idx) => (
              <li key={idx}>
                {user.name} ({user.nickname})
              </li>
            ))}
          </ul>
        )}

        <h1>여행지 목록</h1>
        {travellocations.length === 0 ? (
          <p>불러오는 중...</p>
        ) : (
          <ul>
            {travellocations.map((location, idx) => (
              <li key={idx}>
                {location.location_name} ({location.country})
              </li>
            ))}
          </ul>
        )}

      </header>
    </div>
  );
}

export default App;
*/