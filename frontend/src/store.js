import create from 'zustand';

const useStore = create(set => ({
  portal: null,
  setPortal: (portal) => set({ portal }),
}));

export default useStore;
