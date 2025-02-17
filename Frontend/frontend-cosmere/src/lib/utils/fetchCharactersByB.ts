export interface Character {
    id_Character: number;
    name_Character: string;
    fechaNacimiento: number;
    fechaMuerte: number;
    titulos?: string[];
    id_libro_original: number;
    saga: string;
    // MistBorn
    mistBornType?: string;
    rolSociety?: string;
    capacidades?: string[];
    //StormLight
    radiantOrder?: string;
    bondedSpren?: boolean;
    stormlightLevel?: number;
  }
  
  export async function fetchCharacterByB(id_Book: number): Promise<Character[]> {
    const response = await fetch(`http://localhost:8080/api/books/${id_Book}/characters`);
    
    if (!response.ok) {
      throw new Error('Error fetching books for character');
    }
  
    return response.json();
  }
  
  