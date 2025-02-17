import React from 'react';

export default function EntityRedirect({ items }) {
  if (!items || items.length === 0) return null;

  // Determinamos el tipo de elementos relacionados:
  // Si el primer elemento tiene la propiedad "name_Book", asumimos que son Books
  // (lo que significa que la entidad original es un Character).
  // Si no, se asume que son Characters (entidad original es un Book).
  const isRelatedBooks = items[0].name_Book !== undefined;

  if (isRelatedBooks) {
    // Caso: La entidad es un Character y los relacionados son Books.
    return (
      <div className="contentValorLibrosR">
        <p className="key">Libros Relacionados:</p>
        <div className="value">
          {items.map((item) => (
            <div className="enl_cont" key={item.id_Book}>
              <a
                href="#"
                className="entity-link"
                onClick={(e) => {
                  e.preventDefault();
                  window.location.href = `/books/${item.id_Book}`;
                }}
              >
                {item.name_Book} {item.saga_Book ? `(${item.saga_Book})` : ""}
              </a>
              <p>↗</p>
            </div>
          ))}
        </div>
      </div>
    );
  } else {
    // Caso: La entidad es un Book y los relacionados son Characters.
    return (
      <div className="contentValorLibrosR">
        <p className="key">Characters Relacionados:</p>
        <div className="value">
          {items.map((item) => (
            <div className="enl_cont" key={item.id_Character}>
              <a
                href="#"
                className="entity-link"
                onClick={(e) => {
                  e.preventDefault();
                  window.location.href = `/characters/${item.id_Character}`;
                }}
              >
                {item.name_Character}
              </a>
              <p>↗</p>
            </div>
          ))}
        </div>
      </div>
    );
  }
}
