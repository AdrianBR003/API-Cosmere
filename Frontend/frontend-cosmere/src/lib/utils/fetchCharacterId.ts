export interface Character {
    id_Character: number; 
    name_Character: string;
    age_Character: number;
    id_libro_Original: number; 
    saga_inicial: string;
  }
  
  export async function fetchCharacterId(id: number):Promise<any>{
    const response = await fetch(`http://localhost:8080/api/characters/${id}`)
    if (!response.ok) {
        throw new Error('Error fetching characters');
      }
      return response.json();
  }
