export interface Book {
  id_Book: number;
  name_Book: string;
  page_Book: number;
  saga: string;
}

export async function fetchBooks(): Promise<Book[]> {
  const response = await fetch("http://localhost:8080/api/books");
  if (!response.ok) {
    throw new Error("Error fetching Books");
  }
  return response.json();
}
