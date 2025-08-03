function BlogDetails() {
  const blogs = [
    {
      title: 'React Learning',
      author: 'Stephen Biz',
      content: 'Welcome to learning React!',
    },
    {
      title: 'Installation',
      author: 'Schewzdenier',
      content: 'You can install React from npm.',
    },
  ];

  return (
    <div className="column2">
      <h1>Blog Details</h1>
      {blogs.map((blog, index) => (
        <div key={index}>
          <h2>{blog.title}</h2>
          <h3><strong>{blog.author}</strong></h3>
          <p>{blog.content}</p>
        </div>
      ))}
    </div>
  );
}

export default BlogDetails;