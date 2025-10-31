package dev.datlag.kommons


data object UnitedStatesMinorOutlyingIslands : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("UM")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("UMI")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(581)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(246)
    override val continent: Continent = Continent.Oceania
}