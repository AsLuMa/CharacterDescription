import React, { useEffect, useState } from 'react';
import logo from './logo.svg';
import './App.css';

const App = () => {

  const [stats, setStats] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);

    fetch('api/stats')
      .then(response => response.json())
      .then(data => {
        setStats(data);
        setLoading(false);
      })
  }, []);

  if (loading) {
    return <p>Loading...</p>;
  }

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <div className="App-intro">
          <h2>AAAAAAAAAAAAAAH</h2>
          {stats.map(stat =>
            <div key={stat.id}>
              {stat.name + " "}
              {stat.code + " "}
              {stat.id + " "}
            </div>
          )}
        </div>
      </header>
    </div>
  );
}

export default App;