import { useState } from 'react';
import './App.css';
import BlogDetails from './Components/BlogDetails';
import BookDetails from './Components/BookDetails';
import CourseDetails from './Components/CourseDetails';

function App() {
  const [showCourses, setShowCourses] = useState(true);
  const [showBooks, setShowBooks] = useState(true);
  const [showBlogs, setShowBlogs] = useState(true);

  return (
    <div className="container">
      {showCourses && <CourseDetails />}
      {showBooks ? <BookDetails /> : null}
      {showBlogs ? <BlogDetails /> : <p>No blog to show</p>}
    </div>
  );
}

export default App;
