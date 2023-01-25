export interface LaunchNavigationPlugin {
  openMap(options: OpenMapOptions): Promise<OpenMapResult>;
}

export type OpenMapOptions = {
  longitude: string | number
  latitude: string | number
  address?: string | number
  customer?: string | number
}

export type OpenMapResult = {
  uri?: string
}
