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

export async function fetchCharacterId(id: number): Promise<any> {
  const response = await fetch(`http://localhost:8080/api/characters/${id}`);
  if (!response.ok) {
    throw new Error("Error fetching characters");
  }

  const rawData = await response.json();
  console.log("Respuesta cruda del backend:", rawData);

  // Asegurar que se devuelven todos los atributos
  return {
    id_Character: rawData.id_Character,
    name_Character: rawData.name_Character,
    fechaNacimiento: rawData.fechaNacimiento,
    fechaMuerte: rawData.fechaMuerte ?? null,
    titulos: rawData.titulos ?? [],
    id_libro_original: rawData.id_libro_Original, 
    saga: rawData.saga_inicial, 
    mistBornType: rawData.mistbornType ?? null,
    rolSociety: rawData.rolSociety ?? null,
    capacidades: rawData.capacidades ?? [],
    radiantOrder: rawData.radiantOrder ?? null,
    bondedSpren: rawData.bondedSpren ?? null,
    stormlightLevel: rawData.stormlightLevel ?? 0,
  };
}
