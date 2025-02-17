export interface Book {
    id_Book: number;
    name_Book: string;
    page_Book: number; 
    saga: string;
  }
  
  export async function fetchBookId(id: number): Promise<any> {
    const response = await fetch(`http://localhost:8080/api/books/${id}`);
    if (!response.ok) {
      throw new Error("Error fetching books");
    }
  
    const rawData = await response.json();
    console.log("Respuesta cruda del backend:", rawData);
  
    // Asegurar que se devuelven todos los atributos
    return {
      id_Book: rawData.id_Book,
      name_Book: rawData.name_Book,
      saga: rawData.saga, 
      page_Book: rawData.page_Book,
    };
  }
  