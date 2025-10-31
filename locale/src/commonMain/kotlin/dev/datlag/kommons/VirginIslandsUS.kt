package dev.datlag.kommons


data object VirginIslandsUS : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("VI")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("VIR")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(850)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(1340)
    override val continent: Continent = Continent.NorthAmerica
}