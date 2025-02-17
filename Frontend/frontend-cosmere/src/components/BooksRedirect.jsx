import React from 'react';

export default function BooksRedirectSimple({ books }) {
  const handleClick = (bookId, e) => {
    e.preventDefault();
    console.log("Hiciste clic en el libro con id:", bookId);
    // Redirige a la ruta dinámica, por ejemplo: /books/123
    window.location.href = `/books/${bookId}`;
  };

  if (!books || books.length === 0) return null;

  return (
    <div className="contentValorLibrosR">
      <p className="key">Libros Relacionados:</p>
      <div className="value">
        {books.map((book) => (
          <div className="enl_cont" key={book.id_Book}>
            <a
              href="#"
              className="book-link"
              onClick={(e) => handleClick(book.id_Book, e)}
            >
              {book.name_Book} ({book.saga_Book})
            </a>
            <p>↗</p>
          </div>
        ))}
      </div>
    </div>
  );
}
