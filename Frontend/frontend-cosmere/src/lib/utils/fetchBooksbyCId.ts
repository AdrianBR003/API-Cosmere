export interface Book {
    id_Book: number;
    name_Book: string;
    saga_Book: string;
    pages_Book: number;
  }
  
  export async function fetchBooksByCharacter(id_Character: number): Promise<Book[]> {
    const response = await fetch(`http://localhost:8080/api/characters/${id_Character}/book`);
    
    if (!response.ok) {
      throw new Error('Error fetching books for character');
    }
  
    return response.json();
  }
  
  