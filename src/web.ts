import { WebPlugin } from '@capacitor/core';

import type { LaunchNavigationPlugin, OpenMapOptions, OpenMapResult } from './definitions';

export class LaunchNavigationPluginWeb
  extends WebPlugin
  implements LaunchNavigationPlugin
{
  constructor() {
    super({
      name: 'LaunchNavigationPlugin',
      platforms: ['web']
    });
  }

  async openMap(options: OpenMapOptions): Promise<OpenMapResult> {
    window.open(`https://www.google.com/maps/dir/?api=1&destination=${options.latitude},${options.longitude}&travelmode=driving`, "_blank");
    return  {
      uri: `https://www.google.com/maps/dir/?api=1&destination=${options.latitude},${options.longitude}&travelmode=driving`
    }
  }
}
