package pl.put.poznan.transformer.rest;

public final class RepositoryHolder {
    private BuildingRepository buildingRepository;
    private final static RepositoryHolder INSTANCE = new RepositoryHolder();

    private RepositoryHolder() {}

    public static RepositoryHolder getInstance() {
        return INSTANCE;
    }

    public void setBuildingRepository(BuildingRepository repo) {
        this.buildingRepository = repo;
    }

    public BuildingRepository getBuildingRepository() {
        return this.buildingRepository;
    }
}
