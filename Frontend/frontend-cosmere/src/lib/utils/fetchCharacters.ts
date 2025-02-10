export interface Character{
  id_Character: number, 
  name_Character: string,
  fechaNacimiento: number, 
  fechaMuerte: number, 
  titulos?: string[],
  saga: string, 
  id_libro_original: number
}
  
  export async function fetchCharacters(): Promise<Character[]> {
    const response = await fetch('http://localhost:8080/api/characters'); 
    if (!response.ok) {
      throw new Error('Error fetching characters');
    }
    return response.json();
  }
  