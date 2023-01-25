import { registerPlugin } from '@capacitor/core';

import { LaunchNavigationPlugin } from './definitions';

const LaunchNavigationPlugin = registerPlugin<LaunchNavigationPlugin>(
  'LaunchNavigationPlugin',
  {
    web: () => import('./web').then(m => new m.LaunchNavigationPluginWeb()),
  },
);

export * from './definitions';
export { LaunchNavigationPlugin };
